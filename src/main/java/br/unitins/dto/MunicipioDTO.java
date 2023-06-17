package br.unitins.dto;

import br.unitins.model.Estados;

public record MunicipioDTO(
    Estados estados, 
    String nome
) {

}
