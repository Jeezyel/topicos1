package br.unitins.dto;


public record EnderecoDTO(
    String cep,
    String enderecoCompleto,
    String complemento,
    String referincia,
    Long idEstado
) {

    public EnderecoDTO(String string, String string2, String string3, String string4, int i) {
    }
    
    

}
