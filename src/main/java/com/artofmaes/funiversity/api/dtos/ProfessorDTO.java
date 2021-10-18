package com.artofmaes.funiversity.api.dtos;

public class ProfessorDTO {
    private String id;
    private String firstName;
    private String lastName;

    public ProfessorDTO(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public ProfessorDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ProfessorDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ProfessorDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
