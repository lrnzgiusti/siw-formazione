package it.uniroma3.siw.model;

import javax.persistence.OneToOne;

public class ResponsabileCentro extends Responsabile
{
	@OneToOne
	private Centro centro;

	public ResponsabileCentro(long matricola, String nome, String cognome)
	{
		super(matricola, nome, cognome);
	}
	
}
