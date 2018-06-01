package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Responsabile;

public interface ResponsabileRepository extends CrudRepository<Responsabile, Long> 
{
	public List<Responsabile> findByNome(String nome);
	
	public List<Responsabile> findByCognome(String cognome);
}
