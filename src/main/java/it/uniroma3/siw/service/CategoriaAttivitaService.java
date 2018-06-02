package it.uniroma3.siw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.CategoriaAttivita;
import it.uniroma3.siw.repository.CategoriaAttivitaRepository;

@Transactional
@Service
public class CategoriaAttivitaService
{
	@Autowired
	private CategoriaAttivitaRepository categoriaAttivitaRepository;
	
	
	public CategoriaAttivita save(CategoriaAttivita categoriaAttivita)
	{
		return this.categoriaAttivitaRepository.save(categoriaAttivita);
	}
	
	public List<CategoriaAttivita> findByNomeCategoriaAttivita(String nomeCategoriaAttivita)
	{
		return this.categoriaAttivitaRepository.findByNomeCategoriaAttivita(nomeCategoriaAttivita);
	}
	
	public List<CategoriaAttivita> findAll()
	{
		return (List<CategoriaAttivita>) this.categoriaAttivitaRepository.findAll();
	}

	public CategoriaAttivita findById(Long id) {
		Optional<CategoriaAttivita> categoriaAttivita = this.categoriaAttivitaRepository.findById(id);
		if (categoriaAttivita.isPresent()) 
			return categoriaAttivita.get();
		else
			return null;
	}
}
