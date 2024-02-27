package com.dummy.api.exceptions;

public class RelationshipConstraintViolation extends RuntimeException{
    public RelationshipConstraintViolation(String message){
        super(message);
    }
}
