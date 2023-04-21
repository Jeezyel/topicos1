package br.unitins.dto;

import br.unitins.model.Estados;
import br.unitins.model.Municipio;

public record EstadosResponseDTO(
    String nome,
    String sigla,
    Municipio municipio
) {
    public EstadosResponseDTO (Estados estados){
        this(estados.getSigla(), estados.getNome(), estados.getMunicipio());
    }
    
}
