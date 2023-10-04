package com.beer_revolution.booksAndGames.controller;

import com.beer_revolution.booksAndGames.model.Book;
import com.beer_revolution.booksAndGames.service.BookService;
import com.beer_revolution.booksAndGames.util.MidiaType;
import com.beer_revolution.booksAndGames.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {


    @Autowired
    BookService bookService;


    @GetMapping(value="/{id}",produces = {MidiaType.APPLICATION_JSON})
    public BookVo findById(@PathVariable Long id){
        return bookService.findById(id);

    }


    @GetMapping(produces ={MidiaType.APPLICATION_JSON} )
    public List<BookVo> findAll() {
        return bookService.findAll();
    }

    @PostMapping(consumes={MidiaType.APPLICATION_JSON},produces ={MidiaType.APPLICATION_JSON} )
    public BookVo salvar(@RequestBody BookVo bookVo){

        return bookService.salvar(bookVo);


    }


    @PutMapping(consumes={MidiaType.APPLICATION_JSON},produces ={MidiaType.APPLICATION_JSON} )
    public BookVo Update(@RequestBody BookVo bookVo){
        return bookService.update(bookVo);

    }

    @DeleteMapping("/id")
    public ResponseEntity<?>delete(@PathVariable(value="id")Long id){

        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }




}
