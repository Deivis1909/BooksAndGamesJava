package com.beer_revolution.booksAndGames.unitTestes.mapper.mocks;

import com.beer_revolution.booksAndGames.model.Person;
import com.beer_revolution.booksAndGames.vo.PersonVo;

import java.util.List;
import java.util.ArrayList;

public class MockPerson {
    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonVo mockVO() {
        return mockVO(0);
    }

    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonVo> mockVOList() {
        List<PersonVo> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }

    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setName("name Test" + number);
        person.setSurname("surName Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setEmail("Last email Test" + number);
        return person;
    }

    public PersonVo mockVO(Integer number) {
        PersonVo person = new PersonVo();
        person.setName("name Test" + number);
        person.setSurname("surName Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setKey(number.longValue());
        person.setEmail("Last email Test" + number);
        return person;
    }

}
