package br.unitins.dto;

import java.util.Date;
import java.util.List;

import br.unitins.model.Cliente;
import br.unitins.model.Compra;
import br.unitins.model.Endereco;
import br.unitins.model.ItemCompra;

public record CompraResponseDTO(
    Double totalCompra,
    List<ItemCompra> itemCompra,
    Endereco endereco,
    List<Cliente> cliente
    ) {

    public CompraResponseDTO(Compra compra){
        this( compra.getTotalCompra(), compra.getItemCompra(), compra.getEndereco(), compra.getCliente());

    }
    
}
