package br.unitins.dto;

import br.unitins.model.Municipio;
import org.postgresql.largeobject.LargeObject;

public record EnderecoDTO(
    String cep,
    String enderecoCompleto,
    String complemento,
    String referincia,
    Long idMunicipio
) {
    
    

}
