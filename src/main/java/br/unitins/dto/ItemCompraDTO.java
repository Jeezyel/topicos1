package br.unitins.dto;

import br.unitins.model.Roupas;

public record ItemCompraDTO(

    Integer quantidade,
    Double preco,
    Roupas roupas
) {
    
    

    

}
