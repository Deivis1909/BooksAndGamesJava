package com.beer_revolution.booksAndGames.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;


// faz o mapa/copia do objeto  pra ser transitado , facilita o transito é uma copia do objeto DO VALUE OBJET PERSON VO para transito
// VALOR DE ORIGIN E VALOR DE DESTINO
public class DozerMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O,D> D parseObject(O origin,Class<D> destination){

        return mapper.map(origin,destination);

    }
    public static <O,D> List<D> parseListObject(List<O> origin, Class<D> destination){
        List<D> destinationObjects = new ArrayList<D>();

        for (O o : origin){
            destinationObjects.add(mapper.map(o,destination));
        }

        return destinationObjects;

    }
}
