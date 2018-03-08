package org.lepro.contact;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.lepro.contact.dao.ContactRepository;
import org.lepro.contact.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpContactApplication implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpContactApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat dateNaissance = new SimpleDateFormat("dd/MM/YYYY");
		contactRepository.save(new Contact("NZUI", "AUDRE", dateNaissance.parse("12/01/1992"), "audre@gmail.com",
				0122242, "photo1.jpg"));
		contactRepository.save(new Contact("KAPTUE", "IVAN", dateNaissance.parse("12/01/1992"), "ivan@gmail.com",
				0122242, "photo2.jpg"));
		contactRepository.save(new Contact("KANA", "GILBERT", dateNaissance.parse("12/01/1992"), "gilber@gmail.com",
				0122242, "photo3.jpg"));
		contactRepository.save(new Contact("NONO", "RIANA", dateNaissance.parse("12/01/1992"), "riana@gmail.com",
				0122242, "photo4.jpg"));
		contactRepository.save(new Contact("TATO", "MARTH", dateNaissance.parse("12/01/1992"), "marth@gmail.com",
				0122242, "photo5.jpg"));

		contactRepository.findAll().forEach(c -> {
			System.out.println(c.getNom());
		});
	}
}
