package it.uniroma3.siw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.controller.validator.CentroValidator;
import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.service.CentroService;

@Controller
public class AziendaController 
{

	@Autowired
	private CentroValidator centroValidator; 

	@Autowired
	private CentroService centroService;

	@RequestMapping("/newCentro")
	public String addCentro(Model model)
	{
		model.addAttribute("centro", new Centro());
		return "formCentro";
	}

	@RequestMapping(value = "/centro/{id}", method = RequestMethod.GET)
	public String getCentro(@PathVariable("id") Long id, Model model) {
		model.addAttribute("centro", this.centroService.findById(id));
		return "mostraCentro";
	}

	@RequestMapping(value = "/centro", method = RequestMethod.POST)
	public String newCentro(@Valid @ModelAttribute("centro") Centro centro,
			Model model, BindingResult bindingResult)
	{
		this.centroValidator.validate(centro, bindingResult);
		if(this.centroService.alreadyExists(centro))
		{
			model.addAttribute("exist", "Il centro già esiste");
			return "formCentro";
		}
		else
		{
			if(!bindingResult.hasErrors())
			{
				this.centroService.save(centro);
				model.addAttribute("centri", this.centroService.findAll());
				return "listaCentri";
			}
		}
		return "formCentro";
	}

}
