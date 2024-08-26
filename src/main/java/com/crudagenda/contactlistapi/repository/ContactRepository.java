package com.crudagenda.contactlistapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.crudagenda.contactlistapi.entity.Contact;


public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
