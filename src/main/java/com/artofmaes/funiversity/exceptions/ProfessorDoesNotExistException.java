package com.artofmaes.funiversity.exceptions;

public class ProfessorDoesNotExistException extends RuntimeException {
    public ProfessorDoesNotExistException(String message) {
        super(message);
    }
}
