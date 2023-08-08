package com.beer_revolution.booksAndGames.controller;



import com.beer_revolution.booksAndGames.model.Person;
import com.beer_revolution.booksAndGames.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{id}",method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findBiId(@PathVariable(value = "id")String id) throws Exception{
        return personService.findById(id);



    }



}
