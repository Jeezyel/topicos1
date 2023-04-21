package br.unitins.dto;

import br.unitins.model.Roupas;

public record ItemCompraDTO(
    long id,
    Integer quantidade,
    Double preco,
    Roupas roupas
) {
    
    

    

}
