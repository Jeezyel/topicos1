package br.unitins.dto;

import br.unitins.model.Estados;
import net.bytebuddy.asm.Advice.This;

public record EstadosResouserDTO(
    String nome,
    String sigla,
    MunicipioDTO municipio
) {
    public EstadosResouserDTO (Estados estados){
        this(estados.getSigla(), estados.getNome(), estados.getMunicipio());
    }
    
}
