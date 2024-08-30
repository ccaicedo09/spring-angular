package com.crudagenda.contactlistapi.exception;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("Resource not found!");
    }
}
