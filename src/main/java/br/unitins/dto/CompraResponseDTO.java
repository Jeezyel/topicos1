package br.unitins.dto;


import br.unitins.model.Cliente;
import br.unitins.model.Compra;
import br.unitins.model.Endereco;
import br.unitins.model.ItemCompra;

public record CompraResponseDTO(
    long id,
    Double totalCompra,
    ItemCompra itemCompra,
    Endereco endereco,
    Cliente cliente
    ) {

    public CompraResponseDTO(Compra compra){
        this(
            compra.getId(),
            compra.getTotalCompra(),
            compra.getItemCompra(),
            compra.getEndereco(),
            compra.getCliente()
        );

    }
    
}
