package com.artofmaes.funiversity.api;

import com.artofmaes.funiversity.api.dtos.ProfessorDTO;
import com.artofmaes.funiversity.domain.Professor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ProfessorMapper {
    public Collection<ProfessorDTO> toDTO(Collection<Professor> professors) {
        return professors.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ProfessorDTO toDTO(Professor professor) {
        return new ProfessorDTO(professor.getId(), professor.getFirstName(), professor.getLastName());
    }

    public Professor toEntity(ProfessorDTO professorDTO) {
        return new Professor(professorDTO.getFirstName(), professorDTO.getLastName());
    }
}
