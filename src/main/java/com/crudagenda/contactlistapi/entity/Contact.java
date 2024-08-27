package com.crudagenda.contactlistapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter 
@Setter // Lombok annotations to generate getters and setters
@Entity
@RequiredArgsConstructor // Lombok annotation to generate a constructor with all required fields
@NoArgsConstructor // Lombok annotation to generate a constructor with no arguments
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String phone;

    @NonNull
    private LocalDate createdAt;

}
