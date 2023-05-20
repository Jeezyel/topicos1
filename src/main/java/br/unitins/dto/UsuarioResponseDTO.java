package br.unitins.dto;

import br.unitins.model.Usuario;

public record UsuarioResponseDTO (
String nome,
String email,
String login 
){
    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getNome(), usuario.getEmail(), usuario.getLogin());
    }


    
}
