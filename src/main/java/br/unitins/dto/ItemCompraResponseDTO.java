package br.unitins.dto;

import java.util.List;

import br.unitins.model.ItemCompra;
import br.unitins.model.Roupas;

public record ItemCompraResponseDTO(
    long id,
    Integer quantidadeProduto,
    Double preco,
    List<Roupas> roupas
) {

    public ItemCompraResponseDTO (ItemCompra itemCompra){
        this(itemCompra.getId(),
            itemCompra.getQuantidadeProduto(),
            itemCompra.getPreco(),
            itemCompra.getRoupas());
    }
    
}
