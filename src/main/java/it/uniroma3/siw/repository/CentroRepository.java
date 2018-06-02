package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Centro;

public interface CentroRepository extends CrudRepository<Centro, Long> 
{
	public List<Centro> findByNomeCentro(String nomeCentro);
	
	public List<Centro> findByEmailCentro(String emailCentro);
	
	public List<Centro> findByTelefonoCentro(String telefonoCentro);
	
	public List<Centro> findByNomeCentroAndEmailCentroAndTelefonoCentro(String nomeCentro,
																		String emailCentro,
																		String telefonoCentro);
}
