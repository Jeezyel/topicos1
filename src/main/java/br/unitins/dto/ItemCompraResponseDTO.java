package br.unitins.dto;

import java.util.List;

import br.unitins.model.ItemCompra;
import br.unitins.model.Roupa;

public record ItemCompraResponseDTO(
    long id,
    Integer quantidadeProduto,
    Double preco,
    List<Roupa> roupas
) {

    public ItemCompraResponseDTO (ItemCompra itemCompra){
        this(itemCompra.getId(),
            itemCompra.getQuantidadeProduto(),
            itemCompra.getPreco(),
            itemCompra.getRoupa());
    }
    
}
