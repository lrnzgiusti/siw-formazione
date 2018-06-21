package it.uniroma3.siw.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.controller.validator.ResponsabileValidator;
import it.uniroma3.siw.model.Responsabile;
import it.uniroma3.siw.service.AllievoService;
import it.uniroma3.siw.service.AttivitaService;
import it.uniroma3.siw.service.CentroService;
import it.uniroma3.siw.service.ResponsabileService;

@Controller
public class LoginController
{
	@Autowired
	private ResponsabileService responsabileService;
	@Autowired
	private ResponsabileValidator responsabileValidator;
	@Autowired
	private AllievoService allievoService;
	@Autowired
	private AttivitaService attivitaService;
	@Autowired
	private CentroService centroService;
	
	@RequestMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("responsabile", new Responsabile());
		return "login";
	}
	
	@RequestMapping("/role")
	public String role(HttpSession session,Model model)
	{
		model.addAttribute("allievi", this.allievoService.findAll());
		model.addAttribute("attivita", this.attivitaService.findAll());
		model.addAttribute("responsabili", this.responsabileService.findAll());
		model.addAttribute("centri", this.centroService.findAll());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = auth.getAuthorities().toString();
		Responsabile responsabile = this.responsabileService.findByUsername(auth.getName());
		
		if(role.contains("ROLE_ADMIN"))
		{
			session.setAttribute("responsabileCorrente", responsabile);
			return "admin/dashboard";
		}
		else if(role.contains("ROLE_USER"))
		{
			session.setAttribute("responsabileCorrente", responsabile);
			return "user/dashboard";
		}
		
		return "index";
	}
	
	@RequestMapping("/signUpPage")
	public String signUpPage(Model model)
	{
		model.addAttribute("responsabile", new Responsabile());
		return "signUp";
	}
	
	@RequestMapping(value = "/registrazione", method = RequestMethod.POST)
	public String registrazione(@ModelAttribute("responsabile") Responsabile responsabile, 
								Model model, BindingResult bindingResult)
	{
		this.responsabileValidator.validate(responsabile, bindingResult);
		
		if(this.responsabileService.alredyExists(responsabile))
			model.addAttribute("exists", "Il responsabile già esiste");

		else if(!bindingResult.hasErrors())
		{
			responsabile.setPassword(new BCryptPasswordEncoder().encode(responsabile.getPassword()));
			responsabile.setRole("ROLE_USER");
			this.responsabileService.save(responsabile);
			model.addAttribute("success", "L'account per " + responsabile.getNomeResponsabile() + " è stato creato con successo");
			
			return "login";
		}
		return "signUp";
	}
	
	@RequestMapping("/errore403")
	public String error403()
	{
		return "403";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("responsabileCorrente");
		return "login";
	}
	
}
