package com.company.c;

import java.util.List;

public class FakeDataBase {
    static List<Person> getDatabase() {
        return List.of(
                new Person(1,32,50,"한승민"),
                new Person(2,62,55,"김승민"),
                new Person(3,12,51,"바승민"),
                new Person(1,12,54,"가승민"),
                new Person(3,72,577,"허정윤"),
                new Person(1,92,11,"이문현")
        );
    }
}
