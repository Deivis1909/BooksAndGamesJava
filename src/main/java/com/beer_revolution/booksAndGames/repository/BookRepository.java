package com.beer_revolution.booksAndGames.repository;

import com.beer_revolution.booksAndGames.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
