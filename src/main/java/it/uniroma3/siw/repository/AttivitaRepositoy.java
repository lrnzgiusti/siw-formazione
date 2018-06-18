package it.uniroma3.siw.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Attivita;

public interface AttivitaRepositoy extends CrudRepository<Attivita, Long>
{
	public List<Attivita> findByNomeAttivita(String nomeAttivita);
	
	public List<Attivita> findByDataAttivita(Date dataAttivita);

	public Optional<Attivita> findByNomeAttivitaAndDataAttivita(String nomeAttivita, Date dataAttivita);
}
