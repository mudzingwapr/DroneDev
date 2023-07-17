package com.mudzingwa.medication.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class ResourceNotFoundException extends RuntimeException{
    private String message;
    private String field;
    private Integer id;

    public ResourceNotFoundException(String message,  String field, Integer id) {
        super(String.format("%s Not found with %s of %s",message,field,id));
        this.message = message;
        this.field = field;
        this.id = id;
    }
}
