package it.uniroma3.siw.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.model.Attivita;

public interface AttivitaRepositoy extends CrudRepository<Attivita, Long>
{
	public List<Attivita> findByNomeAttivita(String nomeAttivita);
	
	public List<Attivita> findByDataAttivita(Date dataAttivita);
	
	public List<Allievo> findAllAllievi();
}
