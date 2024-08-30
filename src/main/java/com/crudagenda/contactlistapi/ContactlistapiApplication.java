package com.crudagenda.contactlistapi;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.crudagenda.contactlistapi.entity.Contact;
import com.crudagenda.contactlistapi.repository.ContactRepository;


@SpringBootApplication
public class ContactlistapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactlistapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) { // Adds some data to the database when the application starts
		return args -> {
			List<Contact> contacts = Arrays.asList(
				new Contact("Carlos", "carlos@gmail.com", "123456789", LocalDate.now()),
				new Contact("John", "john@gmail.com", "987654321", LocalDate.now()),
				new Contact("Emily", "emily@gmail.com", "456789123", LocalDate.now()),
				new Contact("Michael", "michael@gmail.com", "789123456", LocalDate.now())
			);
			contactRepository.saveAll(contacts);
		};
	}

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
