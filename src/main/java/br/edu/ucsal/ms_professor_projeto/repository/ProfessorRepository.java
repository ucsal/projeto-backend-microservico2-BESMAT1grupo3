package br.edu.ucsal.ms_professor_projeto.repository;

import br.edu.ucsal.ms_professor_projeto.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository
        extends JpaRepository<Professor, Long> {

    boolean existsByEmail(String email);

}