package com.beer_revolution.booksAndGames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BooksAndGamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksAndGamesApplication.class, args);
	}

}
