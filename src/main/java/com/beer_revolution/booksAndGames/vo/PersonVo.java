package com.beer_revolution.booksAndGames.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;



@JsonPropertyOrder({"id","name","surname","gender","email"})
@Getter
@Setter
public class PersonVo extends RepresentationModel<PersonVo> implements Serializable {
//extends RepresentationModel é do HATEOS -> configura arquivo json de retorno para aperecer coisas como link


    @JsonProperty("id")
    @Mapping("id")
    private Long key;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

}
