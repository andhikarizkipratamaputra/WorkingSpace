package com.example.demo.exceptions;

public class DataMejaNotFoundException extends RuntimeException {

    public DataMejaNotFoundException(Long id){
        super("Could not find DataMeja" + id);
    }


}
