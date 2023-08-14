package com.beer_revolution.booksAndGames.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


// centraliza o controle de excecoes @CONTROLLERAdvice
@RestController
@ControllerAdvice
public class CustumizeResponseEntity extends ResponseEntityExceptionHandler {

    //funcao handleExcpetions para tratar exceçoes
    // que e do tipo funcao nativa do Spring de resposta do servidor/banco de ResponseEntity que
    // usa funcao criada de <ExceptionResponse> de parametro
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleExcpetions(Exception ex, WebRequest request){


    //estanciando a classe de ExceptionResponse e passando os parametros para o metodo construtor
    ExceptionResponse exceptionResponse = new ExceptionResponse(
            // data do erro
            new Date(),
            //mensagem do erro
            ex.getMessage(),
            //descricao do erro
            request.getDescription(false));
                return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);


    }

    // tratando a classe de exceção badRequest
    // que e do tipo funcao nativa do Spring de resposta do servidor/banco de ResponseEntity que
    // usa funcao criada de <ExceptionResponse> de parametro
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(Exception ex,WebRequest request){

        ExceptionResponse exceptionResponse = new ExceptionResponse(

                // data do erro
                new Date(),
                //mensagem do erro
                ex.getMessage(),
                //descricao do erro
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);




    }
}
