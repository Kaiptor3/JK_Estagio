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

import br.com.estagio.entity.UsuarioEntity;
import br.com.estagio.entity.VagaEntity;
import br.com.estagio.service.AlunoService;
import br.com.estagio.service.CursoService;
import br.com.estagio.service.EmpresaService;
import br.com.estagio.service.UsuarioService;
import br.com.estagio.service.VagaService;
import jakarta.servlet.http.HttpSession;

@Controller
public class VagaController {
	
	@Autowired
	private VagaService vagaService;
	
	private String loginUsuarioLogado;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private EmpresaService empresaService;
	
	
	@GetMapping("/vaga")
	public String vaga(ModelMap model)
	{
		model.addAttribute("vagas", vagaService.findAll());
		model.addAttribute("curso", cursoService.findAll());
		model.addAttribute("empresa", empresaService.findAll());
		return "vaga";
	}
	
	@PostMapping("/salvar_vaga")
	public ModelAndView save(
			ModelMap model,
			@ModelAttribute("vagaEntity") VagaEntity vagaEntity,
			RedirectAttributes atributes) throws Exception 
	{
		
			ModelAndView mv = new ModelAndView("redirect:/vaga");
			atributes.addFlashAttribute("mensagem", vagaService.save(vagaEntity));
			return mv;
		
	}
	
	@GetMapping("/alterar_vaga/{idVaga}")
	public ModelAndView update(ModelMap model,@PathVariable("idVaga") Long idVaga) throws Exception 
	{
		
		ModelAndView mv = new ModelAndView("alterar_vaga");
		model.addAttribute("idVaga", idVaga);
		model.addAttribute("vaga", vagaService.getOneByIdVaga(idVaga));
		model.addAttribute("curso", cursoService.findAll());
		model.addAttribute("empresa", empresaService.findAll());
		
		return mv;
	}
	
	@PostMapping("/alterar_vaga")
	public ModelAndView update(
			ModelMap model,
			@ModelAttribute("vagaEntity") VagaEntity vagaEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/vaga");
		atributes.addFlashAttribute("mensagem", vagaService.save(vagaEntity));
		
		return mv;
	}
	
	@GetMapping("/excluir_vaga/{idVaga}")
	public ModelAndView delete(ModelMap model,@PathVariable("idVaga") Long idVaga,RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/vaga");
		model.addAttribute("mensagem",vagaService.deleteById(idVaga));
		model.addAttribute("vaga",vagaService.findAll());
		
		return mv;
			
	}
	
	@GetMapping("/relatorio")
	public String relatorio(ModelMap model, HttpSession session) throws Exception
	{
		loginUsuarioLogado = (String)session.getAttribute("loginusuariologado");
		UsuarioEntity usuario = new UsuarioEntity();
		usuario = usuarioService.getOneByCpf(loginUsuarioLogado);
		model.addAttribute("listvagas", vagaService.getOneByEmpresaId(usuario.getEmpresa().getIdEmpresa()));
		return "relatorio";
	}
	
	@GetMapping("/vagas/{idVaga}")
	public ModelAndView vagas(ModelMap model,@PathVariable("idVaga") Long idVaga) throws Exception
	{
		ModelAndView mv = new ModelAndView("vagas");
		model.addAttribute("idVaga",idVaga);		
		model.addAttribute("alunos", vagaService.getOneByIdVaga(idVaga).getAlunos());
		
		return mv;
	
	}
	
	@GetMapping("/estagios")
	public String estagios(ModelMap model)
	{
		model.addAttribute("vaga", vagaService.findAll());
		return "estagios";
	}
	
	@GetMapping("/infovagas/{idVaga}")
	public ModelAndView infovagas(ModelMap model,@PathVariable("idVaga") Long idVaga) throws Exception
	{
		ModelAndView mv = new ModelAndView("infovagas");
		model.addAttribute("idVaga",idVaga);	
		model.addAttribute("vagas", vagaService.getOneByIdVaga(idVaga));
		mv.addObject("vagas", vagaService.getOneByIdVaga(idVaga));
		return mv;
	}
	
	@PostMapping("/candidatar_vaga")
	public String candidatarVaga(ModelMap model, HttpSession session, @ModelAttribute("vagas") VagaEntity vagaEntity) throws Exception
	{
		System.out.println(vagaEntity.getIdVaga());
		loginUsuarioLogado = (String)session.getAttribute("loginusuariologado");
		UsuarioEntity usuario = new UsuarioEntity();
		usuario = usuarioService.getOneByCpf(loginUsuarioLogado);
		model.addAttribute("alunos", alunoService.getOneByIdAluno(usuario.getAluno().getIdAluno()));
		System.out.println(usuario.getAluno().getIdAluno());
		alunoService.candidatarVaga(usuario.getAluno().getIdAluno(),vagaEntity.getIdVaga());
		return "sucesso";
	}
	
	

}
