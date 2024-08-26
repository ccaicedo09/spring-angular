package com.crudagenda.contactlistapi.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudagenda.contactlistapi.entity.Contact;
import com.crudagenda.contactlistapi.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

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

        Contact contactExists = contactRepository
            .findById(id) 
            .orElse(null);

        contactExists.setName(form.getName());
        contactExists.setEmail(form.getEmail());
        contactExists.setPhone(form.getPhone());

        return contactRepository.save(contactExists);
    }

    public void delete(Integer id) {
        Contact contactExists = contactRepository
                .findById(id)
                .orElse(null);  
        contactRepository.delete(contactExists);
    }
}
