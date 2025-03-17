package com.samsung;

import Models.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    PersonReader jsonToPerson;
    public App() {
        this.jsonToPerson = new PersonReader();
    }
    public App(PersonReader jsonToPerson) {
        this.jsonToPerson = jsonToPerson;
    }

    public List<Person> search(String Keyword)
    {
        List<Person> allPersons = null;
        try {
            allPersons = this.jsonToPerson.fromJson("persons.json");
        }
        catch (IOException e)
        {
        }
        if(allPersons!=null) {
            List<Person> filtered = allPersons.stream().filter(p ->
                            (p.getFirst_name() + " " + p.getLast_name()).toLowerCase().contains(Keyword.toLowerCase())
                                    || p.getEmail().toLowerCase().contains(Keyword.toLowerCase()))
                    .collect(Collectors.toList());
            if (filtered.isEmpty())
                throw new NullPointerException("");
            return filtered;
        }
        return new ArrayList<>();
    }
}
