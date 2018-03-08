package org.lepro.contact.web;

import java.util.List;
import java.util.Optional;

import org.lepro.contact.dao.ContactRepository;
import org.lepro.contact.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestService {
	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public List<Contact> getContacts() {
		return contactRepository.findAll();
	}

	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
	public Optional<Contact> getContact(@PathVariable Long id) {
		return contactRepository.findById(id);
	}

	@RequestMapping(value = "/contacts/save", method = RequestMethod.POST)
	public Contact save(@RequestBody Contact c) {
		return contactRepository.save(c);
	}

}