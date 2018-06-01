package it.uniroma3.siw.model;

import javax.persistence.Entity;

@Entity
public class ResponsabileAzienda extends Responsabile
{

	public ResponsabileAzienda(long matricola, String nome, String cognome)
	{
		super(matricola, nome, cognome);
	}

}
