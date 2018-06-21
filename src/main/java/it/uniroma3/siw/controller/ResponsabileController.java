package it.uniroma3.siw.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.model.Responsabile;
import it.uniroma3.siw.service.CentroService;
import it.uniroma3.siw.service.ResponsabileService;

@Controller
public class ResponsabileController
{
	@Autowired
	private ResponsabileService responsabileService;
	@Autowired
	private CentroService centroService;
	
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
	
	@RequestMapping(value = "/responsabiliLiberi/{id}", method = RequestMethod.GET)
	public String responsabiliLiberi(@PathVariable("id") Long id, Model model, HttpSession session)
	{
		session.setAttribute("centroDaAssegnare", this.centroService.findById(id));
		model.addAttribute("responsabili", this.responsabileService.findByCentroIsNull());
		model.addAttribute("assegna", new String());
		return "admin/listaResponsabili";
	}
	
	@RequestMapping(value = "/assegna/{matricolaResponsabile}", method = RequestMethod.GET)
	public String assegnaCentro(@PathVariable("matricolaResponsabile") Long matricolaResponsabile, HttpSession session, Model model)
	{
		Responsabile resp = this.responsabileService.findById(matricolaResponsabile);
		resp.setCentro((Centro)session.getAttribute("centroDaAssegnare"));
		session.removeAttribute("centroDaAssegnare");
		this.responsabileService.save(resp);
		
		model.addAttribute("responsabili", this.responsabileService.findAll());
		return "admin/listaResponsabili";
	}
}
