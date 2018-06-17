package it.uniroma3.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Responsabile 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "matricola")
	private Long matricolaResponsabile;	
	
	@Column(nullable = false, name = "password")
	private String password;

	@Column(nullable = false, name = "email")
	private String email;

	@Column(nullable = false, name = "username")
	private String username;

	@Column(nullable = false, name = "ruolo")
	private String role;
	
	@Column(nullable = false, name = "nome")
	private String nomeResponsabile;

	@Column(nullable = false, name = "cognome")	
	private String cognomeResponsabile;
	
	public Responsabile()
	{
	}

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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Responsabile [matricolaResponsabile=" + matricolaResponsabile + ", password=" + password + ", email="
				+ email + ", username=" + username + ", role=" + role + ", nomeResponsabile=" + nomeResponsabile
				+ ", cognomeResponsabile=" + cognomeResponsabile + "]";
	}
}
