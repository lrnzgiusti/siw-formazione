package it.uniroma3.siw.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * 
 * @author Lorenzo Giusti, Jacopo Grifoni, Silvio Severino
 *
 */
@Entity
public class Attivita
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private Date dataAttivita;
	
	@ManyToMany
	private List<Allievo> allievi;
	
	@ManyToOne
	private CategoriaAttivita categoria;
	
	public Attivita(String nome, Date data)
	{
		this.nome = nome;
		this.dataAttivita = data;
	}

	public Attivita()
	{
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Date getData()
	{
		return dataAttivita;
	}

	public void setData(Date data)
	{
		this.dataAttivita = data;
	}

	public List<Allievo> getAllievi()
	{
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi)
	{
		this.allievi = allievi;
	}
}
