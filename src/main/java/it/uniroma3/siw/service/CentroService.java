package it.uniroma3.siw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Attivita;
import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.model.Responsabile;
import it.uniroma3.siw.repository.CentroRepository;

@Transactional
@Service
public class CentroService 
{
	@Autowired
	private CentroRepository centroRepository;
	
	public Centro save(Centro centro)
	{
		return this.centroRepository.save(centro);
	}
	
	public List<Centro> findByNomeCentro(String nomeCentro)
	{
		return this.centroRepository.findByNomeCentro(nomeCentro);
	}
	
	public List<Centro> findByEmailCentro(String emailCentro)
	{
		return this.centroRepository.findByEmailCentro(emailCentro);
	}
	
	public List<Centro> findAll()
	{
		return (List<Centro>) this.centroRepository.findAll();
	}
	
	public List<Attivita> findAllAttivitaById(Long id)
	{
		return (List<Attivita>) this.centroRepository.findAllAttivitaById(id);
	}
	
	public Centro findById(Long id) 
	{
		Optional<Centro> centro = this.centroRepository.findById(id);
		if (centro.isPresent()) 
			return centro.get();
		else
			return null;
	}

	public boolean alreadyExists(Centro centro)
	{
		List<Centro> centri = this.centroRepository.findByNomeCentroAndEmailCentroAndTelefonoCentro(centro.getNomeCentro(), 
																									centro.getEmailCentro(), 
																									centro.getTelefonoCentro());
		if (centri.size() > 0)
			return true;
		else 
			return false;
	}

	public List<Centro> findByResponsabileIsNull()
	{
		return this.centroRepository.findByResponsabileCentroIsNull();
	}	
}
