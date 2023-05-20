package br.unitins.dto;

public record UsuarioDTO(
    long id,
    String cpf,
    String nome,
    String email,
    String login 
    ) {
    
}
