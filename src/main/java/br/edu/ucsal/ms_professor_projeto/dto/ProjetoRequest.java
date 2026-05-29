package br.edu.ucsal.ms_professor_projeto.dto;

import br.edu.ucsal.ms_professor_projeto.entity.enums.TipoDemandaProjeto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProjetoRequest {

    private String nome;

    private String objetivo;

    private String publicoAlvo;

    private String localUso;

    private TipoDemandaProjeto tipoDemanda;

    private String escopo;

    private LocalDate dataInicioPrevista;

    private Long professorId;

}