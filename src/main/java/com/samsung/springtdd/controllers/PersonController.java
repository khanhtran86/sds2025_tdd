package com.samsung.springtdd.controllers;

import com.samsung.springtdd.models.Person;
import com.samsung.springtdd.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping()
    public ResponseEntity<List<Person>> getPersons() {
        return ResponseEntity.ok(personService.getAllPerson());
    }

    @PostMapping()
    public ResponseEntity<List<Person>> savePerson(@RequestBody Person person) {
        List<Person> lst = personService.getAllPerson();
        return ResponseEntity.ok(lst);
    }
}
