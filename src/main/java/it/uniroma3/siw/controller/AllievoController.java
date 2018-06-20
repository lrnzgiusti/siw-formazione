package it.uniroma3.siw.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.controller.validator.AllievoValidator;
import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.model.Attivita;
import it.uniroma3.siw.model.Azienda;
import it.uniroma3.siw.model.Responsabile;
import it.uniroma3.siw.service.AllievoService;
import it.uniroma3.siw.service.AttivitaService;

@Controller
public class AllievoController {
	
	@Autowired
	private AllievoValidator allievoValidator; 

	@Autowired
	private AllievoService allievoService;
	
	@Autowired
	private AttivitaService attivitaService;
	
	@RequestMapping("/addAllievo")
	public String addCAllievo(Model model)
	{
		model.addAttribute("allievo", new Allievo());
		return "user/formAllievo";
	}
	
	@RequestMapping("/index")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping(value = "/allievo/{id}", method = RequestMethod.GET)
	public String getCentro(@PathVariable("id") Long id, Model model, HttpSession session) {
		Responsabile resp = (Responsabile)session.getAttribute("responsabileCorrente");
		model.addAttribute("allievo", this.allievoService.findById(id));
		
		if(resp.getRole().contains("ROLE_ADMIN"))
			return "admin/mostraAllievo";
		else if(resp.getRole().contains("ROLE_USER"))
			return "user/mostraAllievo";
		return "user/mostraAllievo";
	}

	@RequestMapping(value = "/allievo", method = RequestMethod.POST)
	public String newCentro(@ModelAttribute("allievo") Allievo allievo,
			Model model, BindingResult bindingResult)
	{
		this.allievoValidator.validate(allievo, bindingResult);
		if(this.allievoService.alreadyExists(allievo))
		{
			model.addAttribute("exist", "L' allievo già esiste");
			return "user/formAllievo";
		}
		else
		{
			if(!bindingResult.hasErrors())
			{
				this.allievoService.save(allievo);
				Azienda.getInstance().addAllievo(allievo);
				return showAllievi(model);
			}
		}
		return "user/formAllievo";
	}

	@RequestMapping("/showAllievi")
	public String showAllievi(Model model)
	{
		model.addAttribute("allievi", this.allievoService.findAll());
		return "user/listaAllievi";
	}
	
	
	/**
	 * ===============================================================
	 * Prenotazione
	 * ===============================================================
	 */
	
	@RequestMapping("/cercaAllievo")
	public String showAttivitaPrenotabili(Model model)
	{
		model.addAttribute("allievo", new Allievo());
		return "user/cercaAllievo";
	}
	
	@RequestMapping("/showAttivitaPrenotabili")
	public String showAttivitaPrenotabili(@Valid @ModelAttribute("allievo") Allievo allievo, Model model, 
																HttpSession session, BindingResult bindingResult)
	{
		this.allievoValidator.validateToPrenotazione(allievo, bindingResult);
		if(this.allievoService.notExists(allievo))
		{
			model.addAttribute("notExists", "L'email inserita non corrisponde a nessun allievo");
			return "user/cercaAllievo";
		}
		if(!bindingResult.hasErrors())
		{
			session.setAttribute("allievoDaPrenotare", this.allievoService.findByEmail(allievo.getEmail()));
			model.addAttribute("attivitas", this.attivitaService.findAll());
			return "user/listaAttivitaPrenotabili";
		}
		return "user/cercaAllievo";
	}
	
	@RequestMapping(value = "/selezionaAttivita/{id}", method = RequestMethod.GET)
	public String selezionaAttivita(@PathVariable("id") Long id, Model model, HttpSession session)
	{
		Attivita att = this.attivitaService.findById(id);
		Allievo all = (Allievo)session.getAttribute("allievoDaPrenotare");
		
		att.addAllievo(all);
		all.addAttivita(att);
		
		this.allievoService.save(all);
		this.attivitaService.save(att);
		
		model.addAttribute("allievo", all);
		session.removeAttribute("allievoDaPrenotare");
		return "user/mostraAllievo";
	}
	
	

	
	

}
