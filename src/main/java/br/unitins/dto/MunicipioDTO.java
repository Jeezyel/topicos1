package br.unitins.dto;

import br.unitins.model.Estados;

public record MunicipioDTO(
    long id,
    Estados estados, 
    String nome
) {

}
