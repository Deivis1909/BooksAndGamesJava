package com.beer_revolution.booksAndGames.service;

import com.beer_revolution.booksAndGames.exception.ResourceNotFoundException;
import com.beer_revolution.booksAndGames.model.Person;
import com.beer_revolution.booksAndGames.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(Long id){

        logger.info("finding one person buscando uma pessoa");



        // setando id com a variavel counter


        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

    }

    public List <Person> findAll(){

        logger.info("find all peaple" +
                "0,");


        return personRepository.findAll();

    }



    public Person salvar(Person person){

        logger.info("salve one person");

        return personRepository.save(person);

    }
    public Person update(Person person){
        logger.info("atualizado a pessoa com sucesso");

       var entity =  personRepository.findById(person.getId())
                .orElseThrow(()-> new ResourceNotFoundException("no records found for this id"));
        entity.setEmail(person.getEmail());
        entity.setGender(person.getGender());
        entity.setSurname(person.getSurname());
        entity.setName(person.getName());

        return personRepository.save(person);

    }
    public void delete(Long id){
        logger.info("deletado com sucesso");
        var entity = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(entity);



    }



}
