package com.example.demo.model.person;

public class Person {
    private String name;
    private String lastName;
    private int age;
    private PersonType type;

    public Person(String name, String lastName, int age, PersonType type) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PersonType getType() {
        return type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name + ';' + lastName +  ';' + age + ';' + type;

    }
}
