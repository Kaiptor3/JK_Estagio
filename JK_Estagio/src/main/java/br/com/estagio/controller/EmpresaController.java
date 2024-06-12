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

import br.com.estagio.entity.EmpresaEntity;
import br.com.estagio.service.EmpresaService;

@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	
	@GetMapping("/empresa") //nome que eu quiser colocar
	public String empresa(ModelMap model)
	{
		model.addAttribute("empresas", empresaService.findAll());
		return "empresa"; //caminho real do arquivo
	}
	
	@PostMapping("/salvar_empresa")
	public ModelAndView save(
			ModelMap model,
			@ModelAttribute("empresaEntity") EmpresaEntity empresaEntity,
			RedirectAttributes atributes) throws Exception 
	{
		
			ModelAndView mv = new ModelAndView("redirect:/empresa");
			atributes.addFlashAttribute("mensagem", empresaService.save(empresaEntity));
			return mv;
		
	}
	
	@GetMapping("/alterar_empresa/{idEmpresa}")
	public ModelAndView update(ModelMap model,@PathVariable("idEmpresa") Long idEmpresa) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("alterar_empresa");
		model.addAttribute("idEmpresa", idEmpresa);
		model.addAttribute("empresa", empresaService.getOneByIdEmpresa(idEmpresa));
		
		return mv;
	}
	
	@PostMapping("/alterar_empresa")
	public ModelAndView update(
			ModelMap model,
			@ModelAttribute("empresaEntity") EmpresaEntity empresaEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/empresa");
		atributes.addFlashAttribute("mensagem", empresaService.save(empresaEntity));
		
		return mv;
	}
	
	@GetMapping("/excluir_empresa/{idEmpresa}")
	public ModelAndView delete(ModelMap model,@PathVariable("idEmpresa") Long idEmpresa,RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/empresa");
		model.addAttribute("mensagem",empresaService.deleteById(idEmpresa));
		model.addAttribute("empresa",empresaService.findAll());
		
		return mv;
			
	}

}
