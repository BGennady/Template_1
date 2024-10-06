package main.java.ru.netology.Builder;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age = OptionalInt.empty(); // по умолчанию неизвестен
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;  // вощвращаем весь объект, а не значения поля
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = OptionalInt.of(age);
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Человек должен иметь имя и фамилию");
        }
        return new Person(name, surname, age.isPresent() ? age.getAsInt() : 0, address);
    }
}
