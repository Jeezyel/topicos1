package br.unitins.dto;

import java.util.List;

import br.unitins.model.Estados;
import br.unitins.model.Municipio;

public record EstadosResponseDTO(
    long id,
    String nome,
    String sigla,
    List<Municipio> municipio
) {
    public EstadosResponseDTO (Estados estados){
        this(estados.getId(),
            estados.getSigla(),
            estados.getNome(),
            estados.getMunicipio());
    }
    
}
