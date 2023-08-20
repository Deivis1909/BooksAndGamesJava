package com.beer_revolution.booksAndGames.unitTestes.mapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.beer_revolution.booksAndGames.mapper.DozerMapper;
import com.beer_revolution.booksAndGames.model.Person;
import com.beer_revolution.booksAndGames.unitTestes.mapper.mocks.MockPerson;
import com.beer_revolution.booksAndGames.vo.PersonVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DozerConverterTest {
    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVo output = DozerMapper.parseObject(inputObject.mockEntity(), PersonVo.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getName());
        assertEquals(" SurName Test0", output.getSurname());
        assertEquals("email Test0", output.getEmail());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVo> outputList = DozerMapper.parseListObject(inputObject.mockEntityList(), PersonVo.class);
        PersonVo outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getName());
        assertEquals(" SurName Test0", outputZero.getSurname());
        assertEquals("email Test0", outputZero.getEmail());
        assertEquals("Male", outputZero.getGender());



        PersonVo outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getName());
        assertEquals("SurName Test7", outputSeven.getSurname());
        assertEquals("Addres email Test7", outputSeven.getEmail());
        assertEquals("Female", outputSeven.getGender());

        PersonVo outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getName());
        assertEquals("SurName Test12", outputTwelve.getSurname());
        assertEquals("Email Test12", outputTwelve.getGender());
        assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozerMapper.parseObject(inputObject.mockVO(), Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getName());
        assertEquals("SurName Test0", output.getSurname());
        assertEquals("email Test0", output.getEmail());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozerMapper.parseListObject(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getName());
        assertEquals("SurName Test0", outputZero.getSurname());
        assertEquals("email Test0", outputZero.getEmail());
        assertEquals("Male", outputZero.getGender());

        Person outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getName());
        assertEquals("surnameName Test7", outputSeven.getSurname());
        assertEquals("email Test7", outputSeven.getEmail());
        assertEquals("Female", outputSeven.getGender());

        Person outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getName());
        assertEquals(" SurName Test12", outputTwelve.getSurname());
        assertEquals("email Test12", outputTwelve.getEmail());
        assertEquals("Male", outputTwelve.getGender());
    }
}

