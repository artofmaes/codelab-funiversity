package com.artofmaes.funiversity.api.dtos;

public class UpdateProfessorDTO {
    private String firstName;
    private String lastName;

/*    public UpdateProfessorDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public UpdateProfessorDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UpdateProfessorDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

}
