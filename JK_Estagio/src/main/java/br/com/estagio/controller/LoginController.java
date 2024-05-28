package br.com.estagio.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@GetMapping("/") //nome que eu quiser colocar
	public String principal()
	{
		return "principal"; //caminho real do arquivo
	}
	
	@GetMapping("/principal")
	public String home(HttpSession session)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName(); //recupera o login do usuario logado     
        
        session.setAttribute("loginusuariologado", login); //inclui na sessção o login do usuário
		return "principal"; //caminho real do arquivo
	}

}
