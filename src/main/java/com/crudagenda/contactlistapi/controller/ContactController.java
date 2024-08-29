package com.crudagenda.contactlistapi.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.crudagenda.contactlistapi.entity.Contact;
import com.crudagenda.contactlistapi.service.ContactService;

import lombok.AllArgsConstructor;

@CrossOrigin
@AllArgsConstructor // Lombok annotation to Constructor injection of the ContactService
@RequestMapping("api/contacts")
@RestController
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public Iterable<Contact> list() {
        return contactService.findAll();
    }

    @GetMapping("/{id}")
    public Contact get(@PathVariable("id") Integer id) {
        return contactService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return contactService.create(contact);
    }

    @PutMapping("/{id}")
    public Contact update(@PathVariable("id") Integer id, @RequestBody Contact form) {
        return contactService.update(id, form);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        contactService.delete(id);
    }

}
