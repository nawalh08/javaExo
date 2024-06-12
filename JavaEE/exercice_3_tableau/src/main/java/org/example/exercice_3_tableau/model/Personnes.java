package org.example.exercice_3_tableau;

public class Personnes {
    private String lastName;
    private String firstName;
    private int age;

    public Personnes(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }
}
