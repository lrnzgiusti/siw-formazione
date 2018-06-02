package it.uniroma3.siw.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.lang.NonNull;

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
	
	@NonNull
	private String nome;

	@NonNull
	private String cognome;
	
	@NonNull
	private String email;
	
	@NonNull
	private String telefono;
	
	@NonNull
	private Date dataNascita; //probabile obsolescenza della classe DATE, vedere GregorianCalendar
	
	@NonNull
	private String luogoNascita;
	
	@ManyToMany(mappedBy = "allievi")
	private List<Attivita> attivita;

	public Allievo(String nome, String cognome, String email, String telefono, Date dataNascita, String luogoNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
	}
	
	public Allievo()
	{}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public List<Attivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(List<Attivita> attivita) {
		this.attivita = attivita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
