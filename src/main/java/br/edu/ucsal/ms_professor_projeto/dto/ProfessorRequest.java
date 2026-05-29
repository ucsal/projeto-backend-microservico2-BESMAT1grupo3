package br.edu.ucsal.ms_professor_projeto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorRequest {

    private String nome;
    private String email;
    private String telefone;
    private String matricula;
    private String escola;

}