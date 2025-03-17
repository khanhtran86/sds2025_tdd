package com.samsung;

import Models.Person;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        App app = new App();
        List<Person> lstResult = app.search("Lawson");

       lstResult.forEach((p)->p.printInfo());
    }
}
