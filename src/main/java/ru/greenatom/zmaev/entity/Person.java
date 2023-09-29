package ru.greenatom.zmaev.entity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import static ru.greenatom.zmaev.util.Constants.*;

public class Person implements Serializable {
    private String name;
    private int age;
    private transient String occupation;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setOccupationByAge() {
        if (age >= 0 && age < 3) {
            occupation = SITTING_HOME;
        } else if (age >= 3 && age < 7) {
            occupation = GOING_KINDERGARTEN;
        } else if (age >= 7 && age < 18) {
            occupation = GOES_TO_SCHOOL;
        } else if (age >= 18 && age < 24) {
            occupation = STUDIES_AT_THE_INSTITUTE;
        } else if (age >= 24 && age < 65) {
            occupation = WORKING;
        } else {
            occupation = RETIRED;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", name, age, occupation);
    }
}
