package br.unitins.dto;

public record EnderecoDTO(

    long id,
    String cep,
    String enderecoCompleto,
    String complemento,
    String referincia,
    EstadosDTO estados
) {
    
    

}
