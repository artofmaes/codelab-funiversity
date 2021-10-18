package com.artofmaes.funiversity.service;

import com.artofmaes.funiversity.api.ProfessorMapper;
import com.artofmaes.funiversity.api.dtos.CreateProfessorDTO;
import com.artofmaes.funiversity.api.dtos.ProfessorDTO;
import com.artofmaes.funiversity.api.dtos.UpdateProfessorDTO;
import com.artofmaes.funiversity.domain.Professor;
import com.artofmaes.funiversity.domain.ProfessorRepository;
import com.artofmaes.funiversity.exceptions.EmptyProfessorListException;
import com.artofmaes.funiversity.exceptions.ProfessorDoesNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;
    private final Logger myLogger = LoggerFactory.getLogger(ProfessorService.class);

    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    //ADD
    public ProfessorDTO createProfessor(CreateProfessorDTO createProfessorDTO) {
        return professorMapper.toDTO(professorRepository.addProfessor(new Professor(createProfessorDTO.getFirstName(), createProfessorDTO.getLastName())));
    }

    //GETTERS
    public ProfessorDTO getProfessor(String id) {
        return professorMapper.toDTO(professorRepository.getById(id));
    }

    public Collection<ProfessorDTO> getProfessors() {
        if(professorRepository.getAll().size() == 0){
            myLogger.warn("No professors found!");
            throw new EmptyProfessorListException("No professors found!");
        }
        return professorMapper.toDTO(professorRepository.getAll());
    }

    //UPDATE
    public ProfessorDTO updateProfessor(String id, UpdateProfessorDTO updateProfessorDTO) {
        if(id == null) {
            myLogger.warn("No professor with this id");
            throw new ProfessorDoesNotExistException("No professor with this id");
        }
        Professor professor = professorMapper.toEntity(getProfessor(id));

        professor.setFirstName(updateProfessorDTO.getFirstName());
        professor.setLastName(updateProfessorDTO.getLastName());
        return professorMapper.toDTO(professorRepository.replaceProfessor(id, professor));
    }


    //DELETE
    public void deleteProfessor(String id) {
        if(id == null) {
            myLogger.warn("No professor with this id");
            throw new ProfessorDoesNotExistException("No professor with this id");
        }
        professorRepository.removeProfessor(id);
    }

}
