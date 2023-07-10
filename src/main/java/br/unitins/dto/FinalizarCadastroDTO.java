package br.unitins.dto;


import br.unitins.model.Endereco;
import br.unitins.model.Telefone;

public record FinalizarCadastroDTO(
    
    Endereco enderecos,
    Telefone telefone
) {
    
}
