package it.uniroma3.siw;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SiwFormazioneApplication extends SpringBootServletInitializer{

	@Autowired
	private DataSaver saver;
	
	public static void main(String[] args) {
		SpringApplication.run(SiwFormazioneApplication.class, args);
	}
	
	@PostConstruct
	public void init()
	{
//		Allievo a = new Allievo("Mario", "Rossi", "mario@uniroma3.it", "3358190234", new Date(1995,10, 12), "Roma");
//		allievoService.save(a);
		saver.save();
		
	}

}
