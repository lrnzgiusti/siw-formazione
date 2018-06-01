package it.uniroma3.siw.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.model.Attivita;
import it.uniroma3.siw.repository.AttivitaRepositoy;

public class AttivitaService
{

	@Autowired
	private AttivitaRepositoy attivitaRepository;


	public Attivita save(Attivita attivita) {
		return this.attivitaRepository.save(attivita);
	}

	public List<Attivita> findByNomeAttivita(String nomeAttivita)
	{
		return this.attivitaRepository.findByNomeAttivita(nomeAttivita);
	}

	public List<Attivita> findByDataAttivita(Date dataAttivita)
	{
		return this.attivitaRepository.findByDataAttivita(dataAttivita);
	}

	public List<Attivita> findAll()
	{
		return (List<Attivita>) this.attivitaRepository.findAll();
	}

	public Attivita findById(Long id) {
		Optional<Attivita> attivita = this.attivitaRepository.findById(id);
		if (attivita.isPresent()) 
			return attivita.get();
		else
			return null;
	}

	public List<Allievo> findAllAllievi(Long idAttivita)
	{
		return findById(idAttivita).getAllievi();
	}
}
