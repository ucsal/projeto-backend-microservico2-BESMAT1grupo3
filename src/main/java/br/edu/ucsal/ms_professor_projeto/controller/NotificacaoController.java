package br.edu.ucsal.ms_professor_projeto.controller;

import br.edu.ucsal.ms_professor_projeto.entity.Notificacao;
import br.edu.ucsal.ms_professor_projeto.service.NotificacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    private final NotificacaoService service;

    public NotificacaoController(
            NotificacaoService service
    ) {
        this.service = service;
    }

    @GetMapping("/professor/{id}")
    public List<Notificacao> listar(
            @PathVariable Long id
    ){
        return service.listar(id);
    }

    @PutMapping("/{id}/ler")
    public Notificacao ler(
            @PathVariable Long id
    ){
        return service.marcarComoLida(id);
    }

}