package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author Lorenzo Giusti, Jacopo Grifoni, Silvio Severino
 *
 */

public class Azienda
{
	
	private String nomeAzienda;
	private String indirizzoAzienda;
	
	private static Azienda single_instance = null;
	
	@OneToMany
	@JoinColumn(name = "allievo_id")
	private List<Allievo> allievi;
	
	@OneToMany
	@JoinColumn(name = "centro_id")
	private List<Centro> centri;
	
	@OneToMany
	@JoinColumn(name = "categoria_id")
	private List<CategoriaAttivita> categorieAttivita;
	
	@OneToOne
	private Responsabile responsabile;
	
	private Azienda()
	{
	}
	
	public static Azienda getInstance()
	{
		if(single_instance == null)
			single_instance = new Azienda();
		return single_instance;
	}

	public String getNome()
	{
		return nomeAzienda;
	}

	public void setNome(String nome)
	{
		this.nomeAzienda = nome;
	}

	public String getIndirizzo()
	{
		return indirizzoAzienda;
	}

	public void setIndirizzo(String indirizzo)
	{
		this.indirizzoAzienda = indirizzo;
	}

}
