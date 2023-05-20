package br.unitins.dto;

import java.util.List;

import br.unitins.model.Endereco;
import br.unitins.model.Roupas;
import br.unitins.model.Telefone;

public record ClienteDTO(
    long id,
    String cpf,
    String nome,
    Endereco enderecos,
    Telefone telefone,
    List<Roupas> listaDeDesejo,
    String nomeImagem
) {
    
}
