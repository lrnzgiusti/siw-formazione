package it.uniroma3.siw;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.model.Attivita;
import it.uniroma3.siw.model.CategoriaAttivita;
import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.model.Responsabile;

public class DataLoader {

	private List<Allievo> allievi;
	private List<CategoriaAttivita> categorieAttivita;
	private List<Centro> centri;
	private List<Responsabile> responsabili;
	private List<Attivita> attivita;
	
	public DataLoader() 
	{
		allievi = new ArrayList<>();
		categorieAttivita = new ArrayList<>();
		centri = new ArrayList<>();
		responsabili = new ArrayList<>();
		attivita = new ArrayList<>();
		loadAllievi();
		loadCategorieAttivita();
		loadCentri();
		loadResponsabili();
		loadAttivita();
	}
	
	@SuppressWarnings("deprecation")
	public void loadAllievi()
	{
		allievi.add(new Allievo("Mario", "Rossi", "mario@uniroma3.it", "3358190234", new Date(1995,10, 12), "Roma"));
		allievi.add(new Allievo("Giuseppe", "Verdi", "giuseppe@uniroma3.it", "3358140234", new Date(1945,12, 5), "Roma"));
		allievi.add(new Allievo("Luca", "Rossi", "luca@uniroma3.it", "3358190254", new Date(1995, 1, 8), "Milano"));
		allievi.add(new Allievo("Lorenzo", "Rossi", "lorenzo@uniroma3.it", "3918593904", new Date(1945, 2, 4), "Napoli"));
		allievi.add(new Allievo("Silvio", "Rossi", "silvio@uniroma3.it", "3819503924", new Date(1955, 3, 11), "Milano"));
		allievi.add(new Allievo("Alessio", "Rossi", "alessio@uniroma3.it", "3818594812", new Date(1965, 5, 12), "Torino"));
		allievi.add(new Allievo("Bruno", "Rossi", "bruno@uniroma3.it", "3828594814", new Date(1975, 12, 10), "Palermo"));
		allievi.add(new Allievo("Federico", "Rossi", "federico@uniroma3.it", "3131469696", new Date(1985, 11, 6), "Taranto"));
		allievi.add(new Allievo("Giovanni", "Rossi", "giovanni@uniroma3.it", "3333333333", new Date(1995, 5, 3), "Ladispoli"));
		allievi.add(new Allievo("Paolo", "Merialdo", "paolo@uniroma3.it", "3444444444", new Date(2005, 3, 4), "Genova"));
		allievi.add(new Allievo("Pippo", "Rossi", "pippo@uniroma3.it", "3585884838", new Date(2015, 1, 1), "Marte"));
		allievi.add(new Allievo("Ciro", "Immobile", "ciro@uniroma3.it", "31257294015", new Date(1996,2, 11), "Scampia"));
	}
	
	public void loadCategorieAttivita()
	{
		categorieAttivita.add(new CategoriaAttivita("Inglese", "Corso inglese"));
		categorieAttivita.add(new CategoriaAttivita("Siw", "Sistemi informativi sul web"));
		categorieAttivita.add(new CategoriaAttivita("Aps", "Analisi e progettazione del software"));
		categorieAttivita.add(new CategoriaAttivita("TLC", "Corso di telecomunicazioni"));
		categorieAttivita.add(new CategoriaAttivita("Vendita", "Vennemose tutto"));
		categorieAttivita.add(new CategoriaAttivita("AI", "Corso intelligenza artificiale"));
		categorieAttivita.add(new CategoriaAttivita("CS", "Corso di calcolo scientifico"));
		categorieAttivita.add(new CategoriaAttivita("Tutto", "Corso che insegna tutto"));
	}
	
	public void loadCentri()
	{
		centri.add(new Centro("Roma 3", "info@uniroma3.it", "3191292948124", 30));
		centri.add(new Centro("British School", "british@schools.it", "31928583123", 450));
		centri.add(new Centro("Roma 4", "info@uniroma4.it", "3124581922031", 340));
		centri.add(new Centro("Roma 2", "info@uniroma2.it", "3219491828591", 230));
		centri.add(new Centro("Roma 1", "info@uniroma1.it", "3219401929451", 10));
	}
	
	public void loadResponsabili()
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Responsabile r1 = new Responsabile("mpaolo", encoder.encode("paolo1"), "admin@roma3.it", "Paolo", "Merialdo",centri.get(0));
		Responsabile r2 = new Responsabile("lrnz", encoder.encode("paolo2"), "admin@roma4.it", "Mario", "Rossi",centri.get(1));
		Responsabile r3 = new Responsabile("sirv", encoder.encode("paolo3"), "admin@roma2.it", "Luca", "Verdi",centri.get(2));
		Responsabile r4 = new Responsabile("oppa", encoder.encode("paolo4"), "admin@roma1.it", "Giovanni", "Agli",centri.get(3));
		Responsabile r5 = new Responsabile("tavolino", encoder.encode("rotto"), "aio@schools.it", "Lorenzo", "Rosso",centri.get(4));
		responsabili.add(r1);
		responsabili.add(r2);
		responsabili.add(r3);
		responsabili.add(r4);
		responsabili.add(r5);
	}
	
	@SuppressWarnings("deprecation")
	public void loadAttivita()
	{
		attivita.add(new Attivita("Inglese", new Date(2018, 8, 2), allievi, categorieAttivita.get(0)));
		attivita.add(new Attivita("Siw", new Date(2018, 3, 20), allievi, categorieAttivita.get(1)));
		attivita.add(new Attivita("Siw", new Date(2018, 3, 22), allievi, categorieAttivita.get(1)));
		attivita.add(new Attivita("Siw", new Date(2018, 3, 19), allievi, categorieAttivita.get(1)));
		attivita.add(new Attivita("Aps", new Date(2018, 2, 12), allievi, categorieAttivita.get(2)));
		attivita.add(new Attivita("TLC", new Date(2018, 12, 16), allievi, categorieAttivita.get(3)));
		attivita.add(new Attivita("Vendita", new Date(2018, 11, 19), allievi, categorieAttivita.get(4)));
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public List<CategoriaAttivita> getCategorieAttivita() {
		return categorieAttivita;
	}

	public List<Centro> getCentri() {
		return centri;
	}

	public List<Responsabile> getResponsabili() {
		return responsabili;
	}

	public List<Attivita> getAttivita() {
		return attivita;
	}
}
