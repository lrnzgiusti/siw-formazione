package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author Lorenzo Giusti, Jacopo Grifoni, Silvio Severino
 *
 */
@Entity
public class Centro
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nomeCentro;
	private String emailCentro;
	private Number telefonoCentro;
	private Integer capienzaMaxCentro;
	
	@OneToMany
	@JoinColumn(name = "categoria_id")
	private List<CategoriaAttivita> categorieDelCentro;
	
	@OneToMany
	@JoinColumn(name = "attivita_id")
	private List<Attivita> attivita;
	
	@OneToOne(mappedBy = "centro")
	private ResponsabileCentro responsabile;
	
	public Centro(String nome, String email, Number telefono, Integer capienzaMax)
	{
		this.nomeCentro = nome;
		this.emailCentro = email;
		this.telefonoCentro = telefono;
		this.capienzaMaxCentro = capienzaMax;
	}
	
	public Centro()
	{
	}

	public long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nomeCentro;
	}

	public void setNome(String nome)
	{
		this.nomeCentro = nome;
	}

	public String getEmail()
	{
		return emailCentro;
	}

	public void setEmail(String email)
	{
		this.emailCentro = email;
	}

	public Number getTelefono()
	{
		return telefonoCentro;
	}

	public void setTelefono(Number telefono)
	{
		this.telefonoCentro = telefono;
	}

	public Integer getCapienzaMax()
	{
		return capienzaMaxCentro;
	}

	public void setCapienzaMax(Integer capienzaMax)
	{
		this.capienzaMaxCentro = capienzaMax;
	}
}
