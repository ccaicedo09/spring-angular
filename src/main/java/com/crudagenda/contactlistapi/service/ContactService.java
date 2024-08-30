package com.crudagenda.contactlistapi.service;

import java.time.LocalDate;


import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.crudagenda.contactlistapi.dto.ContactDTO;
import com.crudagenda.contactlistapi.entity.Contact;
import com.crudagenda.contactlistapi.repository.ContactRepository;

import lombok.AllArgsConstructor; // Lombok annotation to Constructor injection of the ContactRepository

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper mapper;

    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById (Integer id) {
        return contactRepository
            .findById(id)
            .orElse(null);
    }

    public Contact create(ContactDTO contactDTO) {


       Contact contact = mapper.map(contactDTO, Contact.class);

        contact.setCreatedAt(LocalDate.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, ContactDTO contactDTO) {

        Contact contactExists = findById(id);



        mapper.map(contactDTO, contactExists);

        return contactRepository.save(contactExists);
    }

    public void delete(Integer id) {
        Contact contactExists = findById(id);
        contactRepository.delete(contactExists);
    }
}
