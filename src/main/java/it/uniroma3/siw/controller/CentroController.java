package it.uniroma3.siw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.controller.validator.CentroValidator;
import it.uniroma3.siw.model.Attivita;
import it.uniroma3.siw.model.Azienda;
import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.service.CentroService;

@Controller
public class CentroController 
{

	@Autowired
	private CentroValidator centroValidator; 

	@Autowired
	private CentroService centroService;

	@RequestMapping("/addCentro")
	public String addCentro(Model model)
	{
		model.addAttribute("centro", new Centro());
		return "admin/formCentro";
	}

	@RequestMapping(value = "/centro/{id}", method = RequestMethod.GET)
	public String getCentro(@PathVariable("id") Long id, Model model) {
		model.addAttribute("centro", this.centroService.findById(id));
		return "admin/mostraCentro";
	}

	@RequestMapping(value = "/centro", method = RequestMethod.POST)
	public String newCentro(@ModelAttribute("centro") Centro centro,
			Model model, BindingResult bindingResult)
	{
		this.centroValidator.validate(centro, bindingResult);
		if(this.centroService.alreadyExists(centro))
		{
			model.addAttribute("exist", "Il centro già esiste");
			return "admin/formCentro";
		}
		else
		{
			if(!bindingResult.hasErrors())
			{
				this.centroService.save(centro);
				return "admin/listaCentri";
			}
		}
		return "admin/formCentro";
	}

	@RequestMapping("/showCentri")
	public String showCentri(Model model)
	{
		model.addAttribute("centri", this.centroService.findAll());
		return "admin/listaCentri";
	}

	@RequestMapping(value = "/showAttivitaCentro/{id}", method = RequestMethod.GET)
	public String showAttivitaCentro(@PathVariable("id") Long id, Model model)
	{		
		List<Attivita> attivita = this.centroService.findAllAttivitaById(id);
		model.addAttribute("attivitaCentro",attivita);
		return "admin/listaAttivitaCentro";
	}

}
