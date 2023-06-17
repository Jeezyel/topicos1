package br.unitins.dto;

import java.util.Set;

import br.unitins.model.Perfil;

public record UsuarioDTO(
    String login,
    String senha,
    String nomeImagem,
    Set<Perfil> perfis
    ) {
    
}
