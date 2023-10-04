package com.beer_revolution.booksAndGames.unitTestes.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


import com.beer_revolution.booksAndGames.model.Person;
import com.beer_revolution.booksAndGames.repository.PersonRepository;
import com.beer_revolution.booksAndGames.service.PersonService;
import com.beer_revolution.booksAndGames.unitTestes.mapper.mocks.MockPerson;
import com.beer_revolution.booksAndGames.vo.PersonVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

//TestInstance -> ciclo de vida , instancia por class
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {


    //MOCK DE OBJETO PERSON

    MockPerson mockPerson;

    // injetando os MOCKS PARA PERSONREPOSITORY
    @InjectMocks
    private PersonService personService;

    @Mock
    PersonRepository personRepository;

    //setando os mocks externos
    @BeforeEach
    void setUpMocks() throws Exception{

        //variavel input recebe a estancia do objeto de MockPerson
        mockPerson = new MockPerson();

        // ABRINDO / SETANDO MOCKS
        MockitoAnnotations.openMocks(this);


    }

    @Test
    void testFindById() throws Exception {

        // CRIANDO UM OBJETO PERSON QUE RECEBE O INPUT OBJETO DE MOCK PERSON.MOCK DE ENTITY
        Person person = mockPerson.mockEntity(1);


        // MOCKANDO um id PARA TESTAR A FUNCAO
        person.setId(1L);

        // NAO VAI NO REPOSITORIO MESMO

        // RETORNA UM MOCK DE PERSON CRIADO ACIMA COM O ID SETADO

        //WHEN -> QUANDO CHAMA O persoRepository.findbyID() Mockito vai interceptar isso e
        // RETURNA  O person MOCKAdo acima com UM RESPOSITORIO QUE PEGA UM MOCK DE ID
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));
        var result = personService.findById(1L);

        //1 vericicacao que nao esteja nulo
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        //verifica se tem o Hateos e imprimi  o string resultado na tela
        System.out.println(result.toString());
        assertTrue(result.toString().contains("links: [</api/person/1>;rel=\"self\"]"));

        assertEquals("",result.getFirstName());
        assertEquals("",result.getLastName());
        assertEquals("",result.getGender());


    }

    @Test
    void testSalvar() throws Exception {
        // variavel objeto de Person entity recebe o MockPerson input .mockEntity
        Person entity = mockPerson.mockEntity(1);

        //variavel objeto de person - persisted recebe o objeto acima
        Person persisted = entity;


        persisted.setId(1L);



        PersonVo personVo = mockPerson.mockVO(1);

        personVo.setKey(1L);

        //WHEN - QUANDO PERSONREPOSITORY FORM CHAMADADO MOCKITO VAI NTYERCEPTAR E
        // E COLOCAR ENTITY O O OBJETO MOCKADO CRIADO CIMA
        when(personRepository.save(entity)).thenReturn(persisted);



        var result = personService.salvar(personVo);


    }



}
