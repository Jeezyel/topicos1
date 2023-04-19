package br.unitins.dto;

import br.unitins.model.Estados;
import br.unitins.model.Municipio;

public record EstadosResouserDTO(
    String nome,
    String sigla,
    Municipio municipio
) {
    public EstadosResouserDTO (Estados estados){
        this(estados.getSigla(), estados.getNome(), estados.getMunicipio());
    }
    
}
