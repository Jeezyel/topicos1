package br.unitins.dto;

import br.unitins.model.Endereco;

public record EnderecoResouserDTO(
    String cep,
    String enderecoCompleto,
    String complemento,
    String referincia
) {
    public EnderecoResouserDTO(Endereco endereco){

        this(endereco.getReferincia(), endereco.getEnderecoCompleto(), endereco.getComplemento(), endereco.getCep());

    }
    
}
