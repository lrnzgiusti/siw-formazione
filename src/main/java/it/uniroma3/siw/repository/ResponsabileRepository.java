package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Responsabile;

public interface ResponsabileRepository extends CrudRepository<Responsabile, Long> 
{
	public List<Responsabile> findByNomeResponsabile(String nomeResponsabile);
	
	public List<Responsabile> findByCognomeResponsabile(String cognomeResponsabile);
}
