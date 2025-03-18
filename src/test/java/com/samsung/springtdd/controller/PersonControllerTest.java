package com.samsung.springtdd.controller;

import com.samsung.springtdd.controllers.PersonController;
import com.samsung.springtdd.models.Person;
import com.samsung.springtdd.services.PersonService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class) /*Chi dinh day la mot test cho mvc controller*/
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc; /*Object to simulate api call to controller*/

    @MockitoBean
    //@Mock
    //@InjectMocks
    private PersonService personService;

    List<Person> persons;
    @BeforeEach /*Chay truoc moi testcase*/
    void setup()
    {
        persons = Arrays.asList(
                Person.builder().id(1).email("khanh.tx@live.com").first_name("Khanh").last_name("Tran").avatar("").build(),
                Person.builder().id(2).email("txk2601@gmail.com").first_name("Hung").last_name("Nguyen").avatar("").build()
            );
    }
    @AfterEach /*Chay sau moi testcase*/
    void tearDown()
    {

    }

    @Test
    public void shouldReturnAllPersons() throws Exception {
        String jsonResponse = """
                 [
                    {
                        "id": 1,
                        "email": "khanh.tx@live.com",
                        "first_name": "Khanh",
                        "last_name": "Tran",
                        "avatar": ""
                    },{
                        "id": 2,
                        "email": "txk2601@gmail.com",
                        "first_name": "Hung",
                        "last_name": "Nguyen",
                        "avatar": ""
                    }
                 ]
                """;

        //Create mock for getAllPerson() from service
        when(personService.getAllPerson()).thenReturn(persons);

        mockMvc.perform(get("/persons"))
                .andExpect(status().isOk()) //Verify status
                .andExpect(jsonPath("$", Matchers.hasSize(2))) //Verify size of response data
                .andExpect(jsonPath("$[0].id", Matchers.is(1))) //Verify value of 1 property
                .andExpect(content().json(jsonResponse)); //Verify all of response
    }

    @Test
    public void shouldInsertNewPerson() throws Exception {
        when(personService.getAllPerson()).thenReturn(persons);

        mockMvc.perform(post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"khanh.tx@samsung.com\",\"first_name\":\"Khanh\",\"last_name\":\"Tran\",\"avatar\":\"\"}")
                )
                .andExpect(status().isOk());
    }
}
