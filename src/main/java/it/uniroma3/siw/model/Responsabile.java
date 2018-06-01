package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Responsabile 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long matricola;	
	private String nome;
	private String cognome;
	
	public Responsabile(Long matricola, String nome, String cognome)
	{
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public long getMatricola()
	{
		return matricola;
	}
	public void setMatricola(Long matricola)
	{
		this.matricola = matricola;
	}
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public String getCognome()
	{
		return cognome;
	}
	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}
}
