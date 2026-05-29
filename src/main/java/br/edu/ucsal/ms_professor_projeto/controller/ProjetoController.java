package br.edu.ucsal.ms_professor_projeto.controller;

import br.edu.ucsal.ms_professor_projeto.dto.ProjetoRequest;
import br.edu.ucsal.ms_professor_projeto.entity.Projeto;
import br.edu.ucsal.ms_professor_projeto.service.ProjetoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService service;

    public ProjetoController(
            ProjetoService service
    ) {
        this.service = service;
    }

    @PostMapping
    public Projeto criar(
            @RequestBody ProjetoRequest request
    ){
        return service.criar(request);
    }

    @GetMapping
    public List<Projeto> listar(){
        return service.listar();
    }

    @PutMapping("/{id}/aprovar")
    public Projeto aprovar(
            @PathVariable Long id
    ){
        return service.aprovar(id);
    }

    @PutMapping("/{id}/negar")
    public Projeto negar(
            @PathVariable Long id
    ){
        return service.negar(id);
    }

    @PutMapping("/{id}/cancelar")
    public Projeto cancelar(
            @PathVariable Long id
    ){
        return service.cancelar(id);
    }

    @PutMapping("/{id}/finalizar")
    public Projeto finalizar(
            @PathVariable Long id
    ){
        return service.finalizar(id);
    }

}