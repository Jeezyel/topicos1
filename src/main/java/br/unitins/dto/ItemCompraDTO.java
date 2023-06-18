package br.unitins.dto;

import br.unitins.model.Roupa;

public record ItemCompraDTO(
    Integer quantidade,
    Double preco,
    Roupa roupas
) {
    
    

    

}
