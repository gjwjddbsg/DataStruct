package com.company.c;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FakeDataBase.getDatabase().stream()
                .sorted(Comparator.comparing(Person::getName))
                .map(Person::getName)
                .forEach(System.out::println);
        System.out.println("------------");
        FakeDataBase.getDatabase().stream()
                .parallel()
                .sorted(Comparator.comparing(Person::getName))
                .map(Person::getName)
                .forEach(System.out::println);
        FakeDataBase.getDatabase().stream()
                .sorted(Comparator.comparingInt(Person::getId)
                        .thenComparing(Person::getAge)
                        .reversed())
                .filter(x->x.getTall()>=50)
                .map(x->x.getId() +", "+ x.getTall())
                .forEach(System.out::println);

    }
}
