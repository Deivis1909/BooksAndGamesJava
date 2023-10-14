package com.beer_revolution.booksAndGames.controller;



import com.beer_revolution.booksAndGames.model.Person;
import com.beer_revolution.booksAndGames.service.PersonService;
import com.beer_revolution.booksAndGames.vo.PersonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @CROSSORIGIN CONFIGURAÇÃO DE CORS PARA HOSTS LOCAIS DIFERENTES ACESSAR
@CrossOrigin(origins="http://localhost:8090")
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


   // @CrossOrigin(origins="http://localhost:8090")
    //@RequestMapping(value = "/{id}",method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value="/{id}")
    public PersonVo findById(@PathVariable(value = "id")Long id) throws Exception{
        return personService.findById(id);



    }
    //@RequestMapping(method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)

    //@CrossOrigin(origins="http://localhost:8090")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVo> findAll() {
        return personService.findAll();



    }


   // @RequestMapping(method= RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    //@CrossOrigin(origins="http://localhost:8090")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVo salvar(@RequestBody PersonVo personVo) throws Exception {

        return personService.salvar(personVo);
    }

    //@RequestMapping(method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVo atualiza(@RequestBody PersonVo personVo) throws Exception {

        return personService.update(personVo);


    }

    //@RequestMapping(value="{id}",method= RequestMethod.DELETE)
    @DeleteMapping(value="{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id")Long id){

        personService.delete(id);
        return ResponseEntity.noContent().build();



    }




}
