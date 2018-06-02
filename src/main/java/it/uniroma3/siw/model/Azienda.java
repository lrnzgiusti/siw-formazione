package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

/**
 * 
 * @author Lorenzo Giusti, Jacopo Grifoni, Silvio Severino
 *
 */

public class Azienda
{
	@NonNull
	private String nomeAzienda;
	
	@NonNull
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
	
	
	
	private Azienda(String nomeAzienda, String indirizzoAzienda, List<Allievo> allievi, List<Centro> centri,
			List<CategoriaAttivita> categorieAttivita, Responsabile responsabile) {
		this.nomeAzienda = nomeAzienda;
		this.indirizzoAzienda = indirizzoAzienda;
		this.allievi = allievi;
		this.centri = centri;
		this.categorieAttivita = categorieAttivita;
		this.responsabile = responsabile;
	}
	
	private Azienda(String nomeAzienda, String indirizzoAzienda) {
		this.nomeAzienda = nomeAzienda;
		this.indirizzoAzienda = indirizzoAzienda;
	}

	private Azienda()
	{
		centri = new ArrayList<>();
		allievi = new ArrayList<>();
		categorieAttivita = new ArrayList<>();
	}
	
	public static Azienda getInstance()
	{
		if(single_instance == null)
			single_instance = new Azienda();
		return single_instance;
	}

	public String getNomeAzienda() {
		return nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	public String getIndirizzoAzienda() {
		return indirizzoAzienda;
	}

	public void setIndirizzoAzienda(String indirizzoAzienda) {
		this.indirizzoAzienda = indirizzoAzienda;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}
	
	public void addAllievo(Allievo allievo)
	{
		this.allievi.add(allievo);
	}

	public List<Centro> getCentri() {
		return centri;
	}
	
	public void setCentri(List<Centro> centri) {
		this.centri = centri;
	}
	
	public void addCentro(Centro centro)
	{
		this.centri.add(centro);
	}

	public List<CategoriaAttivita> getCategorieAttivita() {
		return categorieAttivita;
	}

	public void setCategorieAttivita(List<CategoriaAttivita> categorieAttivita) {
		this.categorieAttivita = categorieAttivita;
	}

	public void addCategoriaAttivita(CategoriaAttivita categoriaAttivita)
	{
		this.categorieAttivita.add(categoriaAttivita);
	}
	
	public Responsabile getResponsabile() {
		return responsabile;
	}

	public void setResponsabile(Responsabile responsabile) {
		this.responsabile = responsabile;
	}
}
