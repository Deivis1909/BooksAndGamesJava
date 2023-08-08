package com.beer_revolution.booksAndGames.service;

import com.beer_revolution.booksAndGames.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id){

        logger.info("finding one person buscando uma pessoa");

        Person person = new Person();

        // setando id com a variavel counter
        person.setId(counter.incrementAndGet());
        person.setEmail("maradona@camisa10arg@boca.com");
        person.setGender("masculino");
        person.setSurname("diego armando");
        person.setName("Maradona");
        return person;

    }



}
