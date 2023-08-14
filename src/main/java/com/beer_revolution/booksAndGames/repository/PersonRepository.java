package com.beer_revolution.booksAndGames.repository;

import com.beer_revolution.booksAndGames.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

}
