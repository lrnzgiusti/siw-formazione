package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CategoriaAttivita
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, name = "nome")
	private String nomeCategoriaAttivita;
	
	@Column(name = "descrizione")
	private String descrizioneAttivita;
	
	@OneToMany(mappedBy = "categoria")
	private List<Attivita> attivita;

	public CategoriaAttivita(String nomeCategoriaAttivita, String descrizioneAttivita) {
		this.nomeCategoriaAttivita = nomeCategoriaAttivita;
		this.descrizioneAttivita = descrizioneAttivita;
	}

	public CategoriaAttivita() 
	{
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCategoriaAttivita() {
		return nomeCategoriaAttivita;
	}

	public void setNomeCategoriaAttivita(String nomeCategoriaAttivita) {
		this.nomeCategoriaAttivita = nomeCategoriaAttivita;
	}

	public String getDescrizioneAttivita() {
		return descrizioneAttivita;
	}

	public void setDescrizioneAttivita(String descrizioneAttivita) {
		this.descrizioneAttivita = descrizioneAttivita;
	}

	public List<Attivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(List<Attivita> attivita) {
		this.attivita = attivita;
	}
	
	
	
}
