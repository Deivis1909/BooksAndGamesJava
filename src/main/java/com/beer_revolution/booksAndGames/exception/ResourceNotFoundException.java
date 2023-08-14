package com.beer_revolution.booksAndGames.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// vai tratar das badRequest
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public static final long seriaLVersion = 1L;

    //Constructor
    public ResourceNotFoundException(String ex){
        super(ex);

    }

}
