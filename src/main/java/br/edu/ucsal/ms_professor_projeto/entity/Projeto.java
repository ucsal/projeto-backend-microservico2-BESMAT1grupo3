package br.edu.ucsal.ms_professor_projeto.entity;

import br.edu.ucsal.ms_professor_projeto.entity.enums.StatusProjeto;
import br.edu.ucsal.ms_professor_projeto.entity.enums.TipoDemandaProjeto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String objetivo;

    private String publicoAlvo;

    private String localUso;

    @Enumerated(EnumType.STRING)
    private TipoDemandaProjeto tipoDemanda;

    private String escopo;

    private LocalDate dataCriacao;

    private LocalDate dataInicioPrevista;

    private LocalDate dataAprovacao;

    @Enumerated(EnumType.STRING)
    private StatusProjeto status;

    private Long professorId;

    private Long grupoId;

}