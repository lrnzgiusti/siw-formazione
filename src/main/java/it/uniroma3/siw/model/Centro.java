package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.Column;
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
	//provaa
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nomeCentro;
	
	@Column(nullable=false)
	private String emailCentro;
	
	@Column(nullable=false)
	private String telefonoCentro;
	
	@Column(nullable=false)
	private Integer capienzaMaxCentro;
	
	@OneToMany
	@JoinColumn(name = "categoria_id")
	private List<CategoriaAttivita> categorieDelCentro;
	
	@OneToMany
	@JoinColumn(name = "attivita_id")
	private List<Attivita> attivita;
	
	@OneToOne(mappedBy = "centro")
	private ResponsabileCentro responsabileCentro;

	public Centro(String nomeCentro, String emailCentro, String telefonoCentro, Integer capienzaMaxCentro,
			List<CategoriaAttivita> categorieDelCentro, List<Attivita> attivita,
			ResponsabileCentro responsabileCentro)
	{
		this.nomeCentro = nomeCentro;
		this.emailCentro = emailCentro;
		this.telefonoCentro = telefonoCentro;
		this.capienzaMaxCentro = capienzaMaxCentro;
		this.categorieDelCentro = categorieDelCentro;
		this.attivita = attivita;
		this.responsabileCentro = responsabileCentro;
	}

	public Centro(String nomeCentro, String emailCentro, String telefonoCentro, Integer capienzaMaxCentro)
	{
		this.nomeCentro = nomeCentro;
		this.emailCentro = emailCentro;
		this.telefonoCentro = telefonoCentro;
		this.capienzaMaxCentro = capienzaMaxCentro;
	}
	
	public Centro() 
	{
	}

	public String getNomeCentro() {
		return nomeCentro;
	}

	public void setNomeCentro(String nomeCentro) {
		this.nomeCentro = nomeCentro;
	}

	public String getEmailCentro() {
		return emailCentro;
	}

	public void setEmailCentro(String emailCentro) {
		this.emailCentro = emailCentro;
	}

	public String getTelefonoCentro() {
		return telefonoCentro;
	}

	public void setTelefonoCentro(String telefonoCentro) {
		this.telefonoCentro = telefonoCentro;
	}

	public Integer getCapienzaMaxCentro() {
		return capienzaMaxCentro;
	}

	public void setCapienzaMaxCentro(Integer capienzaMaxCentro) {
		this.capienzaMaxCentro = capienzaMaxCentro;
	}

	public List<CategoriaAttivita> getCategorieDelCentro() {
		return categorieDelCentro;
	}

	public void setCategorieDelCentro(List<CategoriaAttivita> categorieDelCentro) {
		this.categorieDelCentro = categorieDelCentro;
	}

	public List<Attivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(List<Attivita> attivita) {
		this.attivita = attivita;
	}

	public ResponsabileCentro getResponsabileCentro() {
		return responsabileCentro;
	}

	public void setResponsabileCentro(ResponsabileCentro responsabileCentro) {
		this.responsabileCentro = responsabileCentro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
