package com.enumDemo.enumDemo.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private String messsage;
    private String field;
    private Integer id;

    public ResourceNotFoundException( String messsage, String field, Integer id) {
        super(String.format("%s With %s of %s not found try another id",messsage,field,id));
        this.messsage = messsage;
        this.field = field;
        this.id = id;
    }
}
