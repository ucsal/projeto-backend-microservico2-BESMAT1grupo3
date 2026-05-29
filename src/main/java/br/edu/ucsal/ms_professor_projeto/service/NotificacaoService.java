package br.edu.ucsal.ms_professor_projeto.service;

import br.edu.ucsal.ms_professor_projeto.entity.Notificacao;
import br.edu.ucsal.ms_professor_projeto.exception.ResourceNotFoundException;
import br.edu.ucsal.ms_professor_projeto.repository.NotificacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacaoService {

    private final NotificacaoRepository repository;

    public NotificacaoService(
            NotificacaoRepository repository
    ) {
        this.repository = repository;
    }

    public Notificacao criar(
            String mensagem,
            Long professorId
    ){

        Notificacao notificacao =
                new Notificacao();

        notificacao.setMensagem(mensagem);
        notificacao.setProfessorId(professorId);
        notificacao.setData(LocalDateTime.now());
        notificacao.setLida(false);

        return repository.save(notificacao);
    }

    public List<Notificacao> listar(
            Long professorId
    ){
        return repository.findByProfessorId(
                professorId
        );
    }

    public Notificacao marcarComoLida(
            Long id
    ){

        Notificacao notificacao =
                repository.findById(id)
                        .orElseThrow(
                                () ->
                                        new ResourceNotFoundException(
                                                "Notificação não encontrada"
                                        )
                        );

        notificacao.setLida(true);

        return repository.save(notificacao);
    }

}