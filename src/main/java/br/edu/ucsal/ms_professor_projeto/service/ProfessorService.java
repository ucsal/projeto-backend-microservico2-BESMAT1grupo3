package br.edu.ucsal.ms_professor_projeto.service;

import br.edu.ucsal.ms_professor_projeto.dto.ProfessorRequest;
import br.edu.ucsal.ms_professor_projeto.entity.Professor;
import br.edu.ucsal.ms_professor_projeto.entity.enums.Status;
import br.edu.ucsal.ms_professor_projeto.exception.ResourceNotFoundException;
import br.edu.ucsal.ms_professor_projeto.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository repository;

    public ProfessorService(
            ProfessorRepository repository
    ) {
        this.repository = repository;
    }

    public Professor criar(ProfessorRequest request){

        if(repository.existsByEmail(request.getEmail())){
            throw new IllegalArgumentException(
                    "Já existe professor com esse email"
            );
        }

        Professor professor = new Professor();

        professor.setNome(request.getNome());
        professor.setEmail(request.getEmail());
        professor.setTelefone(request.getTelefone());
        professor.setMatricula(request.getMatricula());
        professor.setEscola(request.getEscola());

        professor.setDataCadastro(
                LocalDate.now()
        );

        professor.setStatus(Status.ATIVO);

        return repository.save(professor);
    }

    public List<Professor> listar(){
        return repository.findAll();
    }

    public Professor buscar(Long id){

        return repository.findById(id)
                .orElseThrow(
                        () ->
                                new ResourceNotFoundException(
                                        "Professor não encontrado"
                                )
                );
    }

    public Professor ativar(Long id){

        Professor professor = buscar(id);

        professor.setStatus(Status.ATIVO);

        return repository.save(professor);
    }

    public Professor inativar(Long id){

        Professor professor = buscar(id);

        professor.setStatus(Status.INATIVO);

        return repository.save(professor);
    }

}