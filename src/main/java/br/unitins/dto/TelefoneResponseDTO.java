package br.unitins.dto;

import br.unitins.model.Telefone;

public record TelefoneResponseDTO(
    String codigoDeArea,
    String numero,
    Boolean celular
) {

    public TelefoneResponseDTO (Telefone telefone){

        this(telefone.getNumero(), telefone.getCodigoDeArea(), telefone.getCelular());
        
    }    
}
