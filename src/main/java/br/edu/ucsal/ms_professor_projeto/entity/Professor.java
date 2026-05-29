package br.edu.ucsal.ms_professor_projeto.entity;

import br.edu.ucsal.ms_professor_projeto.entity.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;

    private String nome;

    private String email;

    private String telefone;

    private String escola;

    private LocalDate dataCadastro;

    @Enumerated(EnumType.STRING)
    private Status status;

}