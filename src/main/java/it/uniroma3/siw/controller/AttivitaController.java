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

import it.uniroma3.siw.controller.validator.AttivitaValidator;
import it.uniroma3.siw.model.Attivita;
import it.uniroma3.siw.model.CategoriaAttivita;
import it.uniroma3.siw.model.Responsabile;
import it.uniroma3.siw.service.AttivitaService;
import it.uniroma3.siw.service.CategoriaAttivitaService;

@Controller
public class AttivitaController {
	
	@Autowired
	private AttivitaService attivitaService;
	@Autowired
	private CategoriaAttivitaService categoriaAttivitaService;
	@Autowired
	private AttivitaValidator attivitaValidator;
	
	@RequestMapping(value = "/attivita/{id}", method = RequestMethod.GET)
	public String getCentro(@PathVariable("id") Long id, Model model, HttpSession session) {
		model.addAttribute("attivita", this.attivitaService.findById(id));
		
		Responsabile resp = (Responsabile) session.getAttribute("responsabileCorrente");
		if(resp.getRole().contains("ROLE_ADMIN"))
			return "admin/mostraAttivita";
		else if(resp.getRole().contains("ROLE_USER"))
			return "user/mostraAttivita";
		return "admin/dashboard";
	}
	
	@RequestMapping(value = "/selezionaCategoria/{id}", method = RequestMethod.GET)
	public String selezionaCategoria(@PathVariable("id") Long id, Model model, HttpSession session)
	{
		session.setAttribute("categoria", this.categoriaAttivitaService.findById(id));
		model.addAttribute("attivita", new Attivita());
		return "user/formAttivita";
	}
	
	@RequestMapping("/addAttivita")
	public String addAttivita(Model model)
	{
		model.addAttribute("categorieAttivita", this.categoriaAttivitaService.findAll());
		return "user/selezionaCategoria";
	}
	
	@RequestMapping("/showAttivita")
	public String showAttivita(Model model)
	{
		model.addAttribute("attivitas", this.attivitaService.findAll());
		return "user/listaAttivita";
	}
	
	@RequestMapping(value = "/newAttivita", method = RequestMethod.POST)
	public String newAttivita(@Valid @ModelAttribute("attivita") Attivita attivita,
								Model model, BindingResult bindingResult, HttpSession session)
	{
		this.attivitaValidator.validate(attivita,bindingResult);
		if(this.attivitaService.alredyExists(attivita))
		{
			model.addAttribute("exists", "L'attivita già è stata creata");
			return "user/formAttivita";
		}
		if(!bindingResult.hasErrors())
		{
			attivita.setCategoria((CategoriaAttivita)session.getAttribute("categoria"));
			session.removeAttribute("categoria");
			this.attivitaService.save(attivita);
			model.addAttribute("attivitas", this.attivitaService.findAll());
			return "user/listaAttivita";
		}
		return "user/formAttivita";
	}

}
