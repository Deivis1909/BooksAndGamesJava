package com.beer_revolution.booksAndGames.service;

import com.beer_revolution.booksAndGames.controller.BookController;
import com.beer_revolution.booksAndGames.exception.RequiredObjectIsNullException;
import com.beer_revolution.booksAndGames.exception.ResourceNotFoundException;
import com.beer_revolution.booksAndGames.mapper.DozerMapper;
import com.beer_revolution.booksAndGames.model.Book;
import com.beer_revolution.booksAndGames.repository.BookRepository;
import com.beer_revolution.booksAndGames.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service
public class BookService {

    private Logger logger = Logger.getLogger(BookService.class.getName());


    @Autowired
    BookRepository bookRepository;

    public List<BookVo> findAll(){

        logger.info("find all");

        // variavel bocks recebe DozerMapper ParseList com paramentros boookRespository.findAll()
        var books = DozerMapper.parseListObject(bookRepository.findAll(), BookVo.class);

        //variavel books
        books
                // add fluxo
                .stream()
                //para cada
                .forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
        return books;


    }

    public BookVo findById(Long id){

        logger.info("find one book");

        var entity = bookRepository.findById(id)

        //ou entao faça
        // se der merda
        .orElseThrow(()-> new ResourceNotFoundException("finD BY ID NAO FUNCIONA"));

        var vo = DozerMapper.parseObject(entity, BookVo.class);

        vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());

        return vo;


    }

    public BookVo salvar(BookVo bookVo){

        if (bookVo == null) throw new RequiredObjectIsNullException();
        logger.info("salvando livro");
        var entity = DozerMapper.parseObject(bookVo, Book.class);
        var vo = DozerMapper.parseObject(bookRepository.save(entity), BookVo.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;


    }
    // bookVoUpdate
    public BookVo update(BookVo bookVo){
        if(bookVo == null) throw new RequiredObjectIsNullException();
        logger.info("atualizando livro");

        var entity = bookRepository.findById(bookVo.getKey())
                .orElseThrow(()-> new ResourceNotFoundException("nao ta atualizando esse encrenca"));
        entity.setAuthor(bookVo.getAuthor());
        entity.setPrice(bookVo.getPrice());
        entity.setTitle(bookVo.getTitle());
        entity.setLaunchDate(bookVo.getLaunchDate());

        var vo = DozerMapper.parseObject(bookRepository.save(entity), BookVo.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;





    }

    public void delete(Long id){
        logger.info("deletando um livro");
        var entity = bookRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("erro ao buscar pelo id pra deletar"));

        // deleta variavel entity que pegou pelo id
        bookRepository.delete(entity);


    }




}
