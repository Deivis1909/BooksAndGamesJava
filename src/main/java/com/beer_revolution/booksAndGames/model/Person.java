package com.beer_revolution.booksAndGames.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Person implements Serializable {
    private static final long serialVersion = 1L;

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String gender;


}
