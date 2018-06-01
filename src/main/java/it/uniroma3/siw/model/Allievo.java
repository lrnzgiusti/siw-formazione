package it.uniroma3.siw.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 
 * @author Lorenzo Giusti, Jacopo Grifoni, Silvio Severino
 *
 */
@Entity
public class Allievo
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String cognome;
	private String email;
	private Number telefono;
	private Date data_di_nascita; //probabile obsolescenza della classe DATE, vedere GregorianCalendar
	private String luogo_di_nascita;
	
	@ManyToMany(mappedBy = "allievi")
	private List<Attivita> attività;
	
	public Allievo()
	{
	}
	
	public Allievo(String nome, String cognome, String email, Number telefono, Date data_di_nascita,
			String luogo_di_nascita)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
		this.data_di_nascita = data_di_nascita;
		this.luogo_di_nascita = luogo_di_nascita;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
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

	public String getCognome()
	{
		return cognome;
	}

	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Number getTelefono()
	{
		return telefono;
	}

	public void setTelefono(Number telefono)
	{
		this.telefono = telefono;
	}

	public Date getData_di_nascita()
	{
		return data_di_nascita;
	}

	public void setData_di_nascita(Date data_di_nascita)
	{
		this.data_di_nascita = data_di_nascita;
	}

	public String getLuogo_di_nascita()
	{
		return luogo_di_nascita;
	}

	public void setLuogo_di_nascita(String luogo_di_nascita)
	{
		this.luogo_di_nascita = luogo_di_nascita;
	}

	public List<Attivita> getAttività()
	{
		return attività;
	}

	public void setAttività(List<Attivita> attività)
	{
		this.attività = attività;
	}
}
