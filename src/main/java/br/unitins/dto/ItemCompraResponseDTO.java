package br.unitins.dto;

import br.unitins.model.ItemCompra;
import br.unitins.model.Roupas;

public record ItemCompraResponseDTO(
    Integer quantidade,
    Double preco,
    Roupas roupas
) {

    public ItemCompraResponseDTO (ItemCompra itemCompra){
        this(itemCompra.getQuantidade(), itemCompra.getPreco(), itemCompra.getRoupas());
    }
    
}
