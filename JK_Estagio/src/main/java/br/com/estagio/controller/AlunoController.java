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

import br.com.estagio.entity.AlunoEntity;
import br.com.estagio.service.AlunoService;
import br.com.estagio.service.CursoService;
import br.com.estagio.service.EscolaService;



@Controller
public class AlunoController {
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private EscolaService escolaService;
	
	@GetMapping("/aluno")
	public String aluno(ModelMap model)
	{
		model.addAttribute("aluno", alunoService.findAll());
		model.addAttribute("curso", cursoService.findAll());
		model.addAttribute("escola", escolaService.findAll());
		return "aluno";
	}
	
	@PostMapping("/salvar_aluno")
	public ModelAndView save(
			ModelMap model,
			@ModelAttribute("alunoEntity") AlunoEntity alunoEntity,
			RedirectAttributes atributes) throws Exception 
	{
		
			ModelAndView mv = new ModelAndView("redirect:/aluno");
			atributes.addFlashAttribute("mensagem", alunoService.save(alunoEntity));
			return mv;
		
	}
	
	@GetMapping("/alterar_aluno/{idAluno}")
	public ModelAndView update(ModelMap model,@PathVariable("idAluno") Long idAluno) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("alterar_aluno");
		model.addAttribute("escola",escolaService.findAll());
		model.addAttribute("curso",cursoService.findAll());
		model.addAttribute("idAluno", idAluno);
		model.addAttribute("aluno", alunoService.getOneByIdAluno(idAluno));
		
		return mv;
	}
	
	@PostMapping("/alterar_aluno")
	public ModelAndView update(
			ModelMap model,
			@ModelAttribute("alunoEntity") AlunoEntity alunoEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/aluno");
		atributes.addFlashAttribute("mensagem", alunoService.save(alunoEntity));
		
		return mv;
	}
	
	@GetMapping("/excluir_aluno/{idAluno}")
	public ModelAndView delete(ModelMap model,@PathVariable("idAluno") Long idAluno,RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/aluno");
		model.addAttribute("mensagem",alunoService.deleteById(idAluno));
		model.addAttribute("aluno",alunoService.findAll());
		
		return mv;
			
	}
	
	
	
	
}