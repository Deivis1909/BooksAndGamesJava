package com.beer_revolution.booksAndGames.controller;



import com.beer_revolution.booksAndGames.model.Person;
import com.beer_revolution.booksAndGames.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    //@RequestMapping(value = "/{id}",method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value="/{id}")
    public Person findBiId(@PathVariable(value = "id")Long id) throws Exception{
        return personService.findById(id);



    }
    //@RequestMapping(method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return personService.findAll();



    }


   // @RequestMapping(method= RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person salvar(@RequestBody Person person){

        return personService.salvar(person);
    }

    //@RequestMapping(method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person atualiza(@RequestBody Person person){

        return personService.update(person);


    }

    //@RequestMapping(value="{id}",method= RequestMethod.DELETE)
    @DeleteMapping(value="{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id")Long id){

        personService.delete(id);
        return ResponseEntity.noContent().build();



    }




}
