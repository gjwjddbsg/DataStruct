package com.company.c;

public class Person {
    private int id;
    private int age;
    private double tall;
    private String name;

    public Person(int id, int age, double tall, String name) {
        this.id = id;
        this.age = age;
        this.tall = tall;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getTall() {
        return tall;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", tall=" + tall +
                ", name='" + name + '\'' +
                '}';
    }
}
