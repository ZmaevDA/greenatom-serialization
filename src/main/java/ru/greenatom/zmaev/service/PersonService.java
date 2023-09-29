package ru.greenatom.zmaev.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.greenatom.zmaev.entity.Person;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PersonService {

    private static final String FILE_NAME = "people.json";

    private final Gson gson;

    public PersonService() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void serialise(List<Person> personList) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(personList, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> deserialize() throws IOException {
        List<Person> personList;
        try (FileReader reader = new FileReader(FILE_NAME)) {
            personList = gson.fromJson(reader, new TypeToken<List<Person>>() {}.getType());
            for (Person person: personList) {
                person.setOccupationByAge();
            }
        }
        return personList;
    }
}
