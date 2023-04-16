package br.unitins.dto;

import br.unitins.model.Telefone;

public record TelefoneResouserDTO(
    String codigoDeArea,
    String numero,
    Boolean celular
) {

    public TelefoneResouserDTO (Telefone telefone){

        this(telefone.getNumero(), telefone.getCodigoDeArea(), telefone.getCelular());
        
    }    
}
