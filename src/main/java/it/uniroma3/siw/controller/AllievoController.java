package it.uniroma3.siw.controller;

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
import it.uniroma3.siw.model.Azienda;
import it.uniroma3.siw.service.AllievoService;

@Controller
public class AllievoController {
	
	@Autowired
	private AllievoValidator allievoValidator; 

	@Autowired
	private AllievoService allievoService;

	@RequestMapping("/addAllievo")
	public String addCAllievo(Model model)
	{
		model.addAttribute("allievo", new Allievo());
		return "formAllievo";
	}
	
	@RequestMapping("/index")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping(value = "/allievo/{id}", method = RequestMethod.GET)
	public String getCentro(@PathVariable("id") Long id, Model model) {
		model.addAttribute("allievo", this.allievoService.findById(id));
		return "mostraAllievo";
	}

	@RequestMapping(value = "/allievo", method = RequestMethod.POST)
	public String newCentro(@ModelAttribute("allievo") Allievo allievo,
			Model model, BindingResult bindingResult)
	{
		this.allievoValidator.validate(allievo, bindingResult);
		if(this.allievoService.alreadyExists(allievo))
		{
			model.addAttribute("exist", "L' allievo già esiste");
			return "formCentro";
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
		return "formAllievo";
	}

	@RequestMapping("/showAllievi")
	public String showAllievi(Model model)
	{
		model.addAttribute("allievi", this.allievoService.findAll());
		return "listaAllievi";
	}

}
