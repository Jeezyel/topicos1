package br.unitins.dto;

import br.unitins.model.Municipio;

public record MunicipioResponseDTO(
    long id,
    String nome
) {
    public MunicipioResponseDTO(Municipio municipio){
        this(municipio.getId(),
            municipio.getNome());
    }
    
}
