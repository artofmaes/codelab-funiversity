package com.artofmaes.funiversity.api;

import com.artofmaes.funiversity.api.dtos.CreateProfessorDTO;
import com.artofmaes.funiversity.api.dtos.ProfessorDTO;
import com.artofmaes.funiversity.api.dtos.UpdateProfessorDTO;
import com.artofmaes.funiversity.service.ProfessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/professors")
public class ProfessorController {
    private final ProfessorService professorService;

    private final Logger myLogger = LoggerFactory.getLogger(ProfessorController.class);

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    //POSTERS
    @PostMapping(consumes ="application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDTO createProfessor(@RequestBody CreateProfessorDTO createProfessorDTO) {
       myLogger.info("Method createProfessor called");
        return professorService.createProfessor(createProfessorDTO);
    }

    //GETTERS
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessorDTO> getAllProfessors(){
        myLogger.info("Method getAllProfessors called");
        return professorService.getProfessors().stream().toList();}

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDTO getProfessor(@PathVariable("id") String id) {
        myLogger.info("Method getProfessor called");
        return professorService.getProfessor(id);
    }

    //PUTTERS
    @PutMapping(path="/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ProfessorDTO updateProfessor(@PathVariable("id") String id, @RequestBody UpdateProfessorDTO updateProfessorDTO){
        myLogger.info("Method updateProfessor called");
        return professorService.updateProfessor(id, updateProfessorDTO);
    }

    //DELETERS
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteProfessor(@PathVariable("id") String id){
        myLogger.info("Method deleteProfessor called");
        professorService.deleteProfessor(id);
    }
}
