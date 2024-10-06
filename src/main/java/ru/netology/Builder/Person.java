package main.java.ru.netology.Builder;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = OptionalInt.of(age);
    }
    public Person(String name, String surname, int age, String address) {
        this(name, surname, age);
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.address);
    }

    public boolean hasAge() {
        return age.isPresent();  // возвращаем true, если возраст установлен
    }

    public boolean hasAddress() {
        return address != null; // возвращаем true, если адресс установлен
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + "возраст " +
                (age.isPresent() ? age.getAsInt() : "неизвестен") + " " +
                "адресс " + (address != null ? address : "неизвестен"); // Адрес
    }


    @Override
    public int hashCode() {
        int ageHash = age.isPresent() ? age.getAsInt() : 0; // если возраст неизвестен, ставим 0
        return name.hashCode() + surname.hashCode() + ageHash + (address != null ? address.hashCode() : 0);
    }
}

