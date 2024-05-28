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

import br.com.estagio.entity.PermissaoEntity;
import br.com.estagio.service.PermissaoService;

@Controller
public class PermissaoController {
	
	@Autowired
	private PermissaoService permissaoService;
	
	
	@GetMapping("/permissao") //nome que eu quiser colocar
	public String docente(ModelMap model)
	{
		model.addAttribute("permissao", permissaoService.findAll());
		return "permissao"; //caminho real do arquivo
	}
	
	@PostMapping("/salvar_permissao")
	public ModelAndView save(
			ModelMap model,
			@ModelAttribute("permissaoEntity") PermissaoEntity permissaoEntity,
			RedirectAttributes atributes) throws Exception 
	{
		
			ModelAndView mv = new ModelAndView("redirect:/permissao");
			atributes.addFlashAttribute("mensagem", permissaoService.save(permissaoEntity));
			return mv;
		
	}
	@GetMapping("/alterar_permissao/{idPermissao}")
	public ModelAndView update(ModelMap model,@PathVariable("idPermissao") Long idPermissao) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("alterar_permissao");
		model.addAttribute("idPermissao", idPermissao);
		model.addAttribute("permissao", permissaoService.getOneByIdPermissao(idPermissao));
		
		return mv;
	}
	
	@PostMapping("/alterar_permissao")
	public ModelAndView update(
			ModelMap model,
			@ModelAttribute("permissaoEntity") PermissaoEntity permissaoEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/permissao");
		atributes.addFlashAttribute("mensagem", permissaoService.save(permissaoEntity));
		
		return mv;
	}
	
	@GetMapping("/excluir_permissao/{idPermissao}")
	public ModelAndView delete(ModelMap model,@PathVariable("idPermissao") Long idPermissao,RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/permissao");
		model.addAttribute("mensagem", permissaoService.deleteById(idPermissao));
		model.addAttribute("permissao",permissaoService.findAll());
		
		return mv;
		
		
	}

}