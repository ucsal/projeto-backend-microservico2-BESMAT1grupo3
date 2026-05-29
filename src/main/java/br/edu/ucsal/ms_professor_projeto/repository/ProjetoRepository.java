package br.edu.ucsal.ms_professor_projeto.repository;

import br.edu.ucsal.ms_professor_projeto.entity.Projeto;
import br.edu.ucsal.ms_professor_projeto.entity.enums.StatusProjeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetoRepository
        extends JpaRepository<Projeto, Long> {

    List<Projeto> findByStatus(StatusProjeto status);

    List<Projeto> findByProfessorId(Long professorId);

}