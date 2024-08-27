package com.crudagenda.contactlistapi.service;

import java.time.LocalDate;


import org.springframework.stereotype.Service;

import com.crudagenda.contactlistapi.entity.Contact;
import com.crudagenda.contactlistapi.repository.ContactRepository;

import lombok.AllArgsConstructor; // Lombok annotation to Constructor injection of the ContactRepository

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById (Integer id) {
        return contactRepository
            .findById(id)
            .orElse(null);
    }

    public Contact create(Contact contact) {
        contact.setCreatedAt(LocalDate.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, Contact form) {

        Contact contactExists = findById(id);

        contactExists.setName(form.getName());
        contactExists.setEmail(form.getEmail());
        contactExists.setPhone(form.getPhone());

        return contactRepository.save(contactExists);
    }

    public void delete(Integer id) {
        Contact contactExists = findById(id);
        contactRepository.delete(contactExists);
    }
}
