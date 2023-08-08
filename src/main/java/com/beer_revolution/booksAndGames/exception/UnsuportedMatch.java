package com.beer_revolution.booksAndGames.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// vai tratar das badRequest
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMatch extends RuntimeException {
    public static final long seriaLVersion = 1L;

    //Constructor
    public UnsuportedMatch(String ex){
        super(ex);

    }

}
