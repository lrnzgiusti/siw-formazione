package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

@Entity
public class CategoriaAttivita
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	private String nomeCategoriaAttivita;
	
	private String descrizioneAttivita;
	
	@OneToMany
	private List<Attivita> attivita;
	
	public CategoriaAttivita(String nomeAttivita)
	{
		this.nomeCategoriaAttivita = nomeAttivita;
	}

	public CategoriaAttivita()
	{
	}

	public String getNomeAttivita() {
		return nomeCategoriaAttivita;
	}

	public void setNomeAttivita(String nomeAttivita) {
		this.nomeCategoriaAttivita = nomeAttivita;
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
