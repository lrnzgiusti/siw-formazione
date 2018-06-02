package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ResponsabileCentro extends Responsabile
{
	@OneToOne
	private Centro centro;

	public ResponsabileCentro(long matricola, String nome, String cognome, Centro centro)
	{
		super(matricola, nome, cognome);
		this.centro = centro;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}
}
