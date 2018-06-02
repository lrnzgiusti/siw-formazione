package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.CategoriaAttivita;

public interface CategoriaAttivitaRepository extends CrudRepository<CategoriaAttivita, Long>
{
	public List<CategoriaAttivita> findByNome(String nome);
}
