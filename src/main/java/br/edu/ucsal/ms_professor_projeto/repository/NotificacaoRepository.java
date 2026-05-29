package br.edu.ucsal.ms_professor_projeto.repository;

import br.edu.ucsal.ms_professor_projeto.entity.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacaoRepository
        extends JpaRepository<Notificacao, Long> {

    List<Notificacao> findByProfessorId(Long professorId);

}