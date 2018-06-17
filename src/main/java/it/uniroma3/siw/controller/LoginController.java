package it.uniroma3.siw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	
	@RequestMapping(value = "/registrazione", method = RequestMethod.POST)
	public String registrazione(@ModelAttribute("responsabile") Responsabile responsabile, 
								Model model, BindingResult bindingResult)
	{

		//inserire validatore
		
		responsabile.setPassword(new BCryptPasswordEncoder().encode(responsabile.getPassword()));
		responsabile.setRole("ROLE_ADMIN");
		this.responsabileService.save(responsabile); //campi vuoti, si incazza di brutto
		return "index";
	}
	
}
