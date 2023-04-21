package br.unitins.dto;

import br.unitins.model.Municipio;

public record MunicipioResponseDTO(
    String nome
) {
    public MunicipioResponseDTO(Municipio municipio){
        this(municipio.getNome());
    }
    
}
