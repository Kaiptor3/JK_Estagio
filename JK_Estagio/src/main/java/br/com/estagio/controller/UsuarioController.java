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
import br.com.estagio.entity.UsuarioEntity;
import br.com.estagio.repository.UsuarioRepository;
import br.com.estagio.service.PermissaoService;
import br.com.estagio.service.UsuarioService;


@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PermissaoService permissaoService;
	
	@GetMapping("/usuario")
	public String usuario(ModelMap model)
	{
		model.addAttribute("usuarios", usuarioService.findAll());
		model.addAttribute("permissoes", permissaoService.findAll());
		model.addAttribute("usuario", new UsuarioEntity());
		
		return "usuario";
	}
	
	@PostMapping("/salvar_usuario")
	public String save(UsuarioEntity usuarioEntity) {
		
		usuarioRepository.save(usuarioEntity);
		
		return "redirect:/usuario";
	}
	
	@GetMapping("/excluir_usuario/{idUsuario}")
	public ModelAndView delete(ModelMap model,@PathVariable("idUsuario") Long idUsuario,RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/aluno");
		model.addAttribute("mensagem",usuarioService.deleteById(idUsuario));
		model.addAttribute("usuario",usuarioService.findAll());
		
		return mv;
			
	}
	

}
