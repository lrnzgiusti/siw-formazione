package it.uniroma3.siw.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.siw.model.Responsabile;
import it.uniroma3.siw.service.AllievoService;
import it.uniroma3.siw.service.AttivitaService;
import it.uniroma3.siw.service.CentroService;
import it.uniroma3.siw.service.ResponsabileService;

@Controller
public class DashboardController
{
	@Autowired
	private AllievoService allievoService;
	@Autowired
	private AttivitaService attivitaService;
	@Autowired
	private ResponsabileService responsabileService;
	@Autowired
	private CentroService centroService;
	
	@RequestMapping("dashboard")
	public String dashboard(Model model, HttpSession session)
	{
		model.addAttribute("allievi", this.allievoService.findAll());
		model.addAttribute("attivita", this.attivitaService.findAll());
		model.addAttribute("responsabili", this.responsabileService.findAll());
		model.addAttribute("centri", this.centroService.findAll());
		
		Responsabile resp = (Responsabile)session.getAttribute("responsabileCorrente");
		if(resp.getRole().contains("ROLE_USER"))
			return "user/dashboard";
		else if(resp.getRole().contains("ROLE_ADMIN"))
			return "admin/dashboard";
		return "user/dashboard";
	}
}
