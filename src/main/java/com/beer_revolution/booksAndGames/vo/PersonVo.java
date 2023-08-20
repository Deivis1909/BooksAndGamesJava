package com.beer_revolution.booksAndGames.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;



@Getter
@Setter
public class PersonVo implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private String email;

    private String gender;


}
