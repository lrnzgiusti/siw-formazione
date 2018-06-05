package it.uniroma3.siw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.repository.AllievoRepository;

@Transactional
@Service
public class AllievoService 
{
	@Autowired
	private AllievoRepository allievoRepository;
	
	public Allievo save(Allievo allievo)
	{
		return this.allievoRepository.save(allievo);
	}

	public List<Allievo> findByLuogoNascita(String luogoNascita) 
	{
		return this.allievoRepository.findByLuogoNascita(luogoNascita);
	}
	
	public List<Allievo> findByNome(String nome) 
	{
		return this.allievoRepository.findByNome(nome);
	}
	
	public List<Allievo> findbyCognome(String cognome) 
	{
		return this.allievoRepository.findByNome(cognome);
	}
	
	public List<Allievo> findAll() 
	{
		return (List<Allievo>) this.allievoRepository.findAll();
	}
	
	public Allievo findById(Long id) 
	{
		Optional<Allievo> customer = this.allievoRepository.findById(id);
		if (customer.isPresent()) 
			return customer.get();
		else
			return null;
	}

	public boolean alreadyExists(Allievo allievo)
	{
		List<Allievo> allievi = this.allievoRepository.findByNomeAndCognomeAndLuogoNascita(allievo.getNome(), allievo.getCognome(), allievo.getLuogoNascita());
		return allievi.size() > 0;
	}	

}
