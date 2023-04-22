package br.unitins.dto;

import java.util.Date;
import java.util.List;

import br.unitins.model.Compra;
import br.unitins.model.Endereco;
import br.unitins.model.ItemCompra;

public record CompraResponseDTO(
    Date data,
    Double totalCompra,
    List<ItemCompra> itemCompra,
    Endereco endereco) {

    public CompraResponseDTO(Compra compra){
        this(compra.getData(), compra.getTotalCompra(), compra.getItemCompra(), compra.getEndereco());

    }
    
}
