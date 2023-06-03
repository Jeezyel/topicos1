package br.unitins.dto;

import java.util.List;
import java.util.Set;

import br.unitins.model.Endereco;
import br.unitins.model.Perfil;
import br.unitins.model.Roupas;
import br.unitins.model.Telefone;

public record ClienteDTO(
    long id,
    String cpf,
    String nome,
    Endereco enderecos,
    Telefone telefone,
    String login,
    String senha,
    String nomeImagem,
    Set<Perfil> perfis,
    List<Roupas> listaDeDesejo
) {
    
}
