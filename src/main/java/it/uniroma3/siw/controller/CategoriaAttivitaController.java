package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.controller.validator.CategoriaAttivitaValidator;
import it.uniroma3.siw.model.Azienda;
import it.uniroma3.siw.model.CategoriaAttivita;
import it.uniroma3.siw.service.CategoriaAttivitaService;


@Controller
public class CategoriaAttivitaController
{


	@Autowired
	private CategoriaAttivitaValidator categoriaAttivitaValidator; 

	@Autowired
	private CategoriaAttivitaService categoriaAttivitaService;

	@RequestMapping("/addCategoriaAttivita")
	public String addCategoriaAttivita(Model model)
	{
		model.addAttribute("categoriaAttivita", new CategoriaAttivita());
		return "admin/formCategoriaAttivita";
	}
	
	@RequestMapping(value = "/categoriaAttivita/{id}", method = RequestMethod.GET)
	public String getCategoriaAttivita(@PathVariable("id") Long id, Model model) {
		model.addAttribute("categoriaAttivita", this.categoriaAttivitaService.findById(id));
		return "admin/mostraCategoriaAttivita";
	}

	@RequestMapping(value = "/categoriaAttivita", method = RequestMethod.POST)
	public String newCategoriaAttivita(@ModelAttribute("categoriaAttivita") CategoriaAttivita categoriaAttivita,
			Model model, BindingResult bindingResult)
	{
		this.categoriaAttivitaValidator.validate(categoriaAttivita, bindingResult);
		if(this.categoriaAttivitaService.alreadyExists(categoriaAttivita))
		{
			model.addAttribute("exist", "La categoria già esiste");
			return "admin/formCategoriaAttivita";
		}
		else
		{
			if(!bindingResult.hasErrors())
			{
				this.categoriaAttivitaService.save(categoriaAttivita);
				Azienda.getInstance().addCategoriaAttivita(categoriaAttivita);
				return showCategorieAttivita(model);
			}
		}
		return "admin/formCategoriaAttivita";
	}
	
	@RequestMapping("/showCategorieAttivita")
	public String showCategorieAttivita(Model model)
	{
		model.addAttribute("categorieAttivita", this.categoriaAttivitaService.findAll());
		return "admin/listaCategorieAttivita";
	}
	
}
