package com.beer_revolution.booksAndGames.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse implements Serializable {
    private static final long serialVersion = 1L;

    private Date timesTemp;

    private String message;

    private String details;

}
