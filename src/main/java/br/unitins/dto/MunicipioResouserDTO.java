package br.unitins.dto;

import br.unitins.model.Municipio;

public record MunicipioResouserDTO(
    String nome
) {
    public MunicipioResouserDTO(Municipio municipio){
        this(municipio.getNome());
    }
    
}
