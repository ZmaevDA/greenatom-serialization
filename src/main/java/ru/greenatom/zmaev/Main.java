package ru.greenatom.zmaev;


import ru.greenatom.zmaev.entity.Person;
import ru.greenatom.zmaev.service.PersonService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Матвей", 3));
        personList.add(new Person("Полина", 5));
        personList.add(new Person("Владислав", 13));
        personList.add(new Person("Артём", 21));
        personList.add(new Person("Валерий", 54));
        personList.add(new Person("Ольга", 77));
        PersonService service = new PersonService();

        try {
            service.serialise(personList);
            System.out.println("========Список сериализован========");
        } catch (RuntimeException e) {
            System.out.printf("========Ошибка при сериализации: %s========\n", e.getMessage());
        }

        try {
            List<Person> deserializedPersons = service.deserialize();
            System.out.println("========Список десериализован========");
            for (Person person: deserializedPersons) {
                System.out.println(person);
            }
        } catch (IOException e) {
            System.out.printf("========Ошибка при десериализации: %s========\n", e.getMessage());
        }
    }
}