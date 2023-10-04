package com.beer_revolution.booksAndGames.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


// tratando o erro de BAD_REQUEST --REUISIÇÃO QUE NAO EXISTE
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public RequiredObjectIsNullException() {
        super("Deu merda , requisicao nao existe");
    }
    public RequiredObjectIsNullException(String ex) {
        super(ex);
    }


}
