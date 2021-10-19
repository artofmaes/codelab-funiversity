package com.artofmaes.funiversity.service;

import com.artofmaes.funiversity.exceptions.EmptyProfessorListException;
import com.artofmaes.funiversity.exceptions.ProfessorDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyProfessorListException.class)
    protected void emptyProfessorsListException(EmptyProfessorListException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(ProfessorDoesNotExistException.class)
    protected void professorDoesNotExistException(ProfessorDoesNotExistException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }
}
