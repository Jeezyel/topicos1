package br.unitins.dto;

import br.unitins.model.Municipio;

public record EnderecoDTO(
    String cep,
    String enderecoCompleto,
    String complemento,
    String referincia,
    Municipio municipio
) {
    
    

}
