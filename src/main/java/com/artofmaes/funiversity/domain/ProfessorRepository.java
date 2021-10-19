package com.artofmaes.funiversity.domain;


import com.artofmaes.funiversity.exceptions.ProfessorDoesNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProfessorRepository {

    private final ConcurrentHashMap<String, Professor> professorsById;
    private final Logger myLogger = LoggerFactory.getLogger(ProfessorRepository.class);


    public ProfessorRepository() {
        this.professorsById = new ConcurrentHashMap<>();
    }

    public Professor addProfessor(Professor professor) {
        professorsById.put(professor.getId(), professor);
        return professor;
    }

    public Professor replaceProfessor(String id, Professor professor) {
        professorsById.put(id, professor);
        return professor;
    }

    public Professor getById(String id) throws IllegalArgumentException {
        var foundProfessor = professorsById.get(id);
        if (foundProfessor == null) {
            myLogger.warn("NO PROF FOUND!");
            throw new ProfessorDoesNotExistException("No prof could be found " + id);
        }
        return foundProfessor;
    }

    public Collection<Professor> getAll() {
        return professorsById.values();
    }

    public void removeProfessor(String id) {
        professorsById.remove(id);
    }
}
