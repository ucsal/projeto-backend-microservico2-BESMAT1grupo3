package br.edu.ucsal.ms_professor_projeto.exception;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(String mensagem) {
    super(mensagem);
  }

}