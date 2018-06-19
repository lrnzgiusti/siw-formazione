package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.service.ResponsabileService;

@Controller
public class ResponsabileController
{
	@Autowired
	private ResponsabileService responsabileService;
	
	@RequestMapping("/showResponsabili")
	public String showResponsabili(Model model)
	{
		model.addAttribute("responsabili", this.responsabileService.findAll());
		return "admin/listaResponsabili";
	}
	
	@RequestMapping(value = "/responsabile/{matricolaResponsabile}", method = RequestMethod.GET)
	public String mostraResponsabile(@PathVariable("matricolaResponsabile") Long matricolaResponsabile, Model model)
	{
		model.addAttribute("responsabile", this.responsabileService.findById(matricolaResponsabile));
		return "admin/mostraResponsabile";
	}

}
