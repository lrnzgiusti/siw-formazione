package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public abstract class Responsabile 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long matricolaResponsabile;	
	
	@NonNull
	private String nomeResponsabile;
	
	@NonNull
	private String cognomeResponsabile;
	
	public Responsabile(Long matricola, String nome, String cognome)
	{
		this.matricolaResponsabile = matricola;
		this.nomeResponsabile = nome;
		this.cognomeResponsabile = cognome;
	}

	public Long getMatricolaResponsabile() {
		return matricolaResponsabile;
	}

	public void setMatricolaResponsabile(Long matricolaResponsabile) {
		this.matricolaResponsabile = matricolaResponsabile;
	}

	public String getNomeResponsabile() {
		return nomeResponsabile;
	}

	public void setNomeResponsabile(String nomeResponsabile) {
		this.nomeResponsabile = nomeResponsabile;
	}

	public String getCognomeResponsabile() {
		return cognomeResponsabile;
	}

	public void setCognomeResponsabile(String cognomeResponsabile) {
		this.cognomeResponsabile = cognomeResponsabile;
	}
	
}
