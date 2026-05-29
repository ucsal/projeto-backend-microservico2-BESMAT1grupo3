package br.edu.ucsal.ms_professor_projeto.controller;

import br.edu.ucsal.ms_professor_projeto.dto.ProfessorRequest;
import br.edu.ucsal.ms_professor_projeto.entity.Professor;
import br.edu.ucsal.ms_professor_projeto.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService service;

    public ProfessorController(
            ProfessorService service
    ) {
        this.service = service;
    }

    @PostMapping
    public Professor criar(
            @RequestBody ProfessorRequest request
    ){
        return service.criar(request);
    }

    @GetMapping
    public List<Professor> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Professor buscar(
            @PathVariable Long id
    ){
        return service.buscar(id);
    }

    @PutMapping("/{id}/ativar")
    public Professor ativar(
            @PathVariable Long id
    ){
        return service.ativar(id);
    }

    @PutMapping("/{id}/inativar")
    public Professor inativar(
            @PathVariable Long id
    ){
        return service.inativar(id);
    }

}