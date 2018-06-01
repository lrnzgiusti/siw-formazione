package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Allievo;

public interface AllievoRepository extends CrudRepository<Allievo, Long>
{

	public List<Allievo> findByLuogoNascita(String luogoNascita);

	public List<Allievo> findByNome(String nome);
	
	public List<Allievo> findByCognome(String cognome);
	
	public List<Allievo> findByNomeAndCognomeAndLuogoNascita(String nome, String cognome, String luogoNascita);
	
	
}
