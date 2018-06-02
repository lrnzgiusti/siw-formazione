package it.uniroma3.siw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Responsabile;
import it.uniroma3.siw.repository.ResponsabileRepository;

@Transactional
@Service
public class ResponsabileService 
{
	@Autowired
	private ResponsabileRepository responsabileRepository;
	
	public Responsabile save(Responsabile responsabile)
	{
		return this.responsabileRepository.save(responsabile);
	}
	
	public List<Responsabile> findByNomeResponsabile(String nomeResponsabile)
	{
		return this.responsabileRepository.findByNomeResponsabile(nomeResponsabile);
	}
	
	public List<Responsabile> findByCognomeResponsabile(String cognomeResponsabile)
	{
		return this.responsabileRepository.findByCognomeResponsabile(cognomeResponsabile);
	}
	
	public List<Responsabile> findAll()
	{
		return (List<Responsabile>) this.responsabileRepository.findAll();
	}

	public Responsabile findById(Long id) {
		Optional<Responsabile> responsabile = this.responsabileRepository.findById(id);
		if (responsabile.isPresent()) 
			return responsabile.get();
		else
			return null;
	}
}
