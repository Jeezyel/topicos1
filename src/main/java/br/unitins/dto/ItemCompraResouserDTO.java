package br.unitins.dto;

import br.unitins.model.ItemCompra;
import br.unitins.model.Roupas;

public record ItemCompraResouserDTO(
    Integer quantidade,
    Double preco,
    Roupas roupas
) {

    public ItemCompraResouserDTO (ItemCompra itemCompra){
        this(itemCompra.getQuantidade(), itemCompra.getPreco(), itemCompra.getRoupas());
    }
    
}
