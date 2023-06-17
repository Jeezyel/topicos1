package br.unitins.dto;

import java.util.Set;

import br.unitins.model.Perfil;

public record ClienteSimplesDTO(
    String cpf,
    String nome,
    String login,
    String senha,
    Set<Perfil> perfis
) {
    
}
