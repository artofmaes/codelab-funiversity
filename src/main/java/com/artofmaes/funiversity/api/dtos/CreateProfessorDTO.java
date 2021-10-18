package com.artofmaes.funiversity.api.dtos;

public class CreateProfessorDTO {

    private String firstName;
    private String lastName;

    public CreateProfessorDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public CreateProfessorDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateProfessorDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
