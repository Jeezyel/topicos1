package br.unitins.dto;

import java.util.Set;

import br.unitins.model.Perfil;

public record ClienteSimplesDTO(
    long id,
    String cpf,
    String nome,
    String login,
    String senha,
    Set<Perfil> perfis
) {
    
}
