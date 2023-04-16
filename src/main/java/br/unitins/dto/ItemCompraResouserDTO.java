package br.unitins.dto;

import br.unitins.model.ItemCompra;

public record ItemCompraResouserDTO(
    Integer quantidade,
    Double preco,
    RoupasDTO roupas
) {

    public ItemCompraResouserDTO (ItemCompra itemCompra){
        this(itemCompra.getQuantidade(), itemCompra.getPreco(), itemCompra.getRoupas())
    }
    
}
