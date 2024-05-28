package br.com.estagio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.estagio.entity.EscolaEntity;
import br.com.estagio.service.EscolaService;

@Controller
public class EscolaController {
	
	@Autowired
	private EscolaService escolaService;
	
	@GetMapping("/escola")
	public String escola(ModelMap model)
	{
		model.addAttribute("escola", escolaService.findAll());
		return "escola";
	}
	
	@PostMapping("/salvar_escola")
	public ModelAndView save(
			ModelMap model,
			@ModelAttribute("escolaEntity") EscolaEntity escolaEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/escola");
		atributes.addFlashAttribute("mensagem", escolaService.save(escolaEntity));
		return mv;
	}
	
	@GetMapping("/alterar_escola/{idEscola}")
	public ModelAndView update(ModelMap model,@PathVariable("idEscola") Long idEscola) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("alterar_escola");
		model.addAttribute("idEscola", idEscola);
		model.addAttribute("escola", escolaService.getOneByIdEscola(idEscola));
		
		return mv;
	}
	
	@PostMapping("/alterar_escola")
	public ModelAndView update(
			ModelMap model,
			@ModelAttribute("escolaEntity") EscolaEntity escolaEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/escola");
		atributes.addFlashAttribute("mensagem", escolaService.save(escolaEntity));
		
		return mv;
	}
	
	@GetMapping("/excluir_escola/{idEscola}")
	public ModelAndView delete(ModelMap model,@PathVariable("idEscola") Long idEscola,RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/escola");
		model.addAttribute("mensagem",escolaService.deleteById(idEscola));
		model.addAttribute("escola",escolaService.findAll());
		
		return mv;
		
		
	}

	
	
	
	
	
	
	
	
	
}
