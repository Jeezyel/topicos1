package br.unitins.dto;

import br.unitins.model.Endereco;

public record EnderecoResponseDTO(
    String cep,
    String enderecoCompleto,
    String complemento,
    String referincia
) {
    public EnderecoResponseDTO(Endereco endereco){

        this(endereco.getReferincia(), endereco.getEnderecoCompleto(), endereco.getComplemento(), endereco.getCep());

    }
    
}
