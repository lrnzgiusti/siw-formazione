package it.uniroma3.siw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.model.Attivita;
import it.uniroma3.siw.model.CategoriaAttivita;
import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.model.Responsabile;
import it.uniroma3.siw.service.AllievoService;
import it.uniroma3.siw.service.AttivitaService;
import it.uniroma3.siw.service.CategoriaAttivitaService;
import it.uniroma3.siw.service.CentroService;
import it.uniroma3.siw.service.ResponsabileService;

@Service
public class DataSaver 
{
	@Autowired
	private AllievoService allievoService;
	
	@Autowired
	private CategoriaAttivitaService categoriaAttivitaService;
	
	@Autowired
	private CentroService centroService;
	
	@Autowired
	private ResponsabileService responsabileService;
	
	@Autowired
	private AttivitaService attivitaService;
	
	private DataLoader loader;
	
	public DataSaver() 
	{
		allievoService = new AllievoService();
		categoriaAttivitaService = new CategoriaAttivitaService();
		centroService = new CentroService();
		responsabileService = new ResponsabileService();
		attivitaService = new AttivitaService();
		loader = new DataLoader();
	}
	
	public void saveAllievi()
	{
		for(Allievo allievo: loader.getAllievi())
		{
			allievoService.save(allievo);
		}
	}
	
	public void saveCategorieAttivita()
	{
		for(CategoriaAttivita categoriaAttivita : loader.getCategorieAttivita())
		{
			categoriaAttivitaService.save(categoriaAttivita);
		}
	}
	
	public void saveCentri()
	{
		for(Centro centro: loader.getCentri())
		{
			centroService.save(centro);
		}
	}
	
	public void saveResponsabili()
	{
		for(Responsabile responsabile : loader.getResponsabili())
		{
			responsabileService.save(responsabile);
		}
	}
	
	public void saveAttivita()
	{
		for(Attivita attivita : loader.getAttivita())
		{
			attivitaService.save(attivita);
		}
	}
	
	public void save()
	{
		saveAllievi();
		saveCategorieAttivita();
		saveCentri();
		saveResponsabili();
		saveAttivita();
	}
	
}