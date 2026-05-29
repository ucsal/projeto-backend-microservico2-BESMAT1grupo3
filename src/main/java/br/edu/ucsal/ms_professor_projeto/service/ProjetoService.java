package br.edu.ucsal.ms_professor_projeto.service;

import br.edu.ucsal.ms_professor_projeto.dto.ProjetoRequest;
import br.edu.ucsal.ms_professor_projeto.entity.Projeto;
import br.edu.ucsal.ms_professor_projeto.entity.enums.StatusProjeto;
import br.edu.ucsal.ms_professor_projeto.exception.ResourceNotFoundException;
import br.edu.ucsal.ms_professor_projeto.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository repository;
    private final NotificacaoService notificacaoService;

    public ProjetoService(
            ProjetoRepository repository,
            NotificacaoService notificacaoService
    ) {
        this.repository = repository;
        this.notificacaoService =
                notificacaoService;
    }

    public Projeto criar(
            ProjetoRequest request
    ){

        Projeto projeto = new Projeto();

        projeto.setNome(request.getNome());
        projeto.setObjetivo(request.getObjetivo());
        projeto.setPublicoAlvo(
                request.getPublicoAlvo()
        );
        projeto.setLocalUso(
                request.getLocalUso()
        );
        projeto.setEscopo(
                request.getEscopo()
        );

        projeto.setProfessorId(
                request.getProfessorId()
        );

        projeto.setTipoDemanda(
                request.getTipoDemanda()
        );

        projeto.setDataCriacao(
                LocalDate.now()
        );

        projeto.setDataInicioPrevista(
                request.getDataInicioPrevista()
        );

        projeto.setStatus(
                StatusProjeto.SOLICITADO
        );

        return repository.save(projeto);
    }

    public List<Projeto> listar(){
        return repository.findAll();
    }

    public Projeto buscar(Long id){

        return repository.findById(id)
                .orElseThrow(
                        () ->
                                new ResourceNotFoundException(
                                        "Projeto não encontrado"
                                )
                );
    }

    public Projeto aprovar(Long id){

        Projeto projeto = buscar(id);

        projeto.setStatus(
                StatusProjeto.APROVADO
        );

        projeto.setDataAprovacao(
                LocalDate.now()
        );

        notificacaoService.criar(
                "Projeto aprovado",
                projeto.getProfessorId()
        );

        return repository.save(projeto);
    }

    public Projeto negar(Long id){

        Projeto projeto = buscar(id);

        projeto.setStatus(
                StatusProjeto.NEGADO
        );

        notificacaoService.criar(
                "Projeto negado",
                projeto.getProfessorId()
        );

        return repository.save(projeto);
    }

    public Projeto cancelar(Long id){

        Projeto projeto = buscar(id);

        projeto.setStatus(
                StatusProjeto.CANCELADO
        );

        notificacaoService.criar(
                "Projeto cancelado",
                projeto.getProfessorId()
        );

        return repository.save(projeto);
    }

    public Projeto finalizar(Long id){

        Projeto projeto = buscar(id);

        projeto.setStatus(
                StatusProjeto.FINALIZADO
        );

        notificacaoService.criar(
                "Projeto finalizado",
                projeto.getProfessorId()
        );

        return repository.save(projeto);
    }

}