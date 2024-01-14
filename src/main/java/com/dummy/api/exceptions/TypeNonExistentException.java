package com.dummy.api.exceptions;

public class TypeNonExistentException extends RuntimeException{
    public TypeNonExistentException(String type){
        super("The '" + type + "' type does not exist.");
    }
}
