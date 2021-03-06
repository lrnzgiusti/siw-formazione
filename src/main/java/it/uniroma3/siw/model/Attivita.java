package it.uniroma3.siw.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

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
	
	@NonNull
	private String nomeAttivita;
	
	@NonNull
	@Temporal (TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataAttivita;
	
	@ManyToMany
	private List<Allievo> allievi;
	
	@ManyToOne
	private CategoriaAttivita categoria;

	public Attivita(String nomeAttivita, Date dataAttivita, List<Allievo> allievi, CategoriaAttivita categoria) {
		this.nomeAttivita = nomeAttivita;
		this.dataAttivita = dataAttivita;
		this.allievi = allievi;
		this.categoria = categoria;
	}

	public Attivita(String nomeAttivita, Date dataAttivita) {
		this.nomeAttivita = nomeAttivita;
		this.dataAttivita = dataAttivita;
	}
	
	public Attivita()
	{}
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getNomeAttivita() {
		return nomeAttivita;
	}

	public void setNomeAttivita(String nomeAttivita) {
		this.nomeAttivita = nomeAttivita;
	}

	public Date getDataAttivita() {
		return dataAttivita;
	}

	public void setDataAttivita(Date dataAttivita) {
		this.dataAttivita = dataAttivita;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public CategoriaAttivita getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaAttivita categoria) {
		this.categoria = categoria;
	}

	@Transactional
	public void addAllievo(Allievo allievo)
	{
		this.allievi.add(allievo);
	}
}
