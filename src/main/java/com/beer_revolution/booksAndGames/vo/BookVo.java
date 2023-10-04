package com.beer_revolution.booksAndGames.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@JsonPropertyOrder({"id","author","launchDate", "price", "title"})
public class BookVo extends RepresentationModel<BookVo> implements Serializable {

    @JsonProperty("id")
    @Mapping("id")
    private Long key;



    private String author;



    private Date launchDate;


    private Double price;



    private String title;

}
