package com.samsung;

import Models.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PersonReader {
    public List<Person> fromJson(String fileName) throws IOException
    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL fileUrl = classLoader.getResource(fileName);
        Gson gson = new Gson();
        File file = new File(fileUrl.getFile());

        JsonReader reader = new JsonReader(new FileReader(file));

        Type userListType = new TypeToken<List<Person>>() {}.getType();
        List<Person> persons = gson.fromJson(reader, userListType);
        return persons;

    }
}
