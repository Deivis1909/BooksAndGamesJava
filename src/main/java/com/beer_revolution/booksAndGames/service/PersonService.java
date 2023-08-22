package com.beer_revolution.booksAndGames.service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.beer_revolution.booksAndGames.controller.PersonController;
import com.beer_revolution.booksAndGames.exception.ResourceNotFoundException;
import com.beer_revolution.booksAndGames.mapper.DozerMapper;
import com.beer_revolution.booksAndGames.model.Person;
import com.beer_revolution.booksAndGames.repository.PersonRepository;
import com.beer_revolution.booksAndGames.vo.PersonVo;
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

    public PersonVo findById(Long id) throws Exception {

        logger.info("finding one person buscando uma pessoa");

        var entity = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));



        var vo = DozerMapper.parseObject(entity, PersonVo.class);

        // aplicando Hateos
        // construindo a variavek de retotno que retorna um findbyid withselfRel = auto relacionamento que aparece o link da procura
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;


    }

    public List <PersonVo> findAll(){

        logger.info("find all peaple" +
                "0,");


       var persons = DozerMapper.parseListObject(personRepository.findAll(), PersonVo.class);
        persons
                .stream()
                .forEach(p -> {
                    try {
                        p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
       return persons;

    }



    public PersonVo salvar(PersonVo personVo) throws Exception {



        logger.info("salve one person");


        // variavel entity vai fazer um parseObject coverter um objeto persoVo em  um objeto person
        var entity = DozerMapper.parseObject(personVo,Person.class);


        // salvando entity personVo no banco e
        // covertendo a entidade obeto persom em uma variavel personVo para retornar Vo
        var vo = DozerMapper.parseObject(personRepository.save(entity),PersonVo.class);
        // aplicando Hateos
        // construindo a variavek de retotno que retorna um findbyid withselfRel = auto relacionamento que aparece o link da procura
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;

    }
    public PersonVo update(PersonVo personVo) throws Exception {
        logger.info("atualizado a pessoa com sucesso");

       var entity =  personRepository.findById(personVo.getKey())
                .orElseThrow(()-> new ResourceNotFoundException("no records found for this id"));
        entity.setEmail(personVo.getEmail());
        entity.setGender(personVo.getGender());
        entity.setSurname(personVo.getSurname());
        entity.setName(personVo.getName());

        // salvando entity personVo no banco e
        // covertendo a entidade obeto persom em uma variavel personVo para retornar Vo
        var vo = DozerMapper.parseObject(personRepository.save(entity),PersonVo.class);
        // aplicando Hateos
        // construindo a variavek de retotno que retorna um findbyid withselfRel = auto relacionamento que aparece o link da procura
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;

    }
    public void delete(Long id){
        logger.info("deletado com sucesso");
        var entity = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(entity);



    }



}
