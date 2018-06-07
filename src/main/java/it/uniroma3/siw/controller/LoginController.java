package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.siw.model.Responsabile;
import it.uniroma3.siw.service.ResponsabileService;

@Controller
public class LoginController
{
	@Autowired
	private ResponsabileService responsabileService;
	
	@RequestMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("responsabile", new Responsabile());
		return "login";
	}
	
}
