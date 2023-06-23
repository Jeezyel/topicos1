package br.unitins.dto;

import java.util.Set;

import br.unitins.model.Endereco;
import br.unitins.model.Perfil;
import br.unitins.model.Telefone;

public record ClienteDTO(
    String cpf,
    String nome,
    Endereco enderecos,
    Telefone telefone,
    String login,
    String senha,
    String nomeImagem,
    Set<Perfil> perfis
) {
    
}
