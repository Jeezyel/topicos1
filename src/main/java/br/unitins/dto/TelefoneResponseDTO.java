package br.unitins.dto;

import br.unitins.model.Telefone;

public record TelefoneResponseDTO(
    long id,
    String codigoDeArea,
    String numero,
    Boolean celular
) {

    public TelefoneResponseDTO (Telefone telefone){

        this(telefone.getId(), telefone.getNumero(), telefone.getCodigoDeArea(), telefone.getCelular());
        
    }    
}
