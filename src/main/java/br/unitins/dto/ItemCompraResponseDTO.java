package br.unitins.dto;

import java.util.List;

import br.unitins.model.ItemCompra;
import br.unitins.model.Roupas;

public record ItemCompraResponseDTO(
    Integer quantidade,
    Double preco,
    List<Roupas> roupas
) {

    public ItemCompraResponseDTO (ItemCompra itemCompra){
        this(itemCompra.getQuantidade(), itemCompra.getPreco(), itemCompra.getRoupas());
    }
    
}
