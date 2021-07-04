package com.example.demo.Exceptions;

public class IdNotFoundException extends RuntimeException {

    public IdNotFoundException(Long id){
        super("Could not find DataMeja" + id);
    }


}
