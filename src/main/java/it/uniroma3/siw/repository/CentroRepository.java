package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Attivita;
import it.uniroma3.siw.model.Centro;

public interface CentroRepository extends CrudRepository<Centro, Long> 
{
	public List<Centro> findByNomeCentro(String nomeCentro);
	
	public List<Centro> findByEmailCentro(String emailCentro);
	
	public List<Attivita> findAllAttivitaById(Long id);
	
	public List<Centro> findByTelefonoCentro(String telefonoCentro);
	
	public List<Centro> findByNomeCentroAndEmailCentroAndTelefonoCentro(String nomeCentro,
																		String emailCentro,
																		String telefonoCentro);
	
	@Query(nativeQuery=true, value = "select * "
			+ "from centro "
			+ "where centro.id NOT IN "
			+ "(select centro.id from centro join responsabile on centro.id = responsabile.centro_id )")
	public List<Centro> findByResponsabileCentroIsNull();
}
