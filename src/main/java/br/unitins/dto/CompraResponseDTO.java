package br.unitins.dto;

import java.util.List;

import br.unitins.model.Cliente;
import br.unitins.model.Compra;
import br.unitins.model.Comprovante;
import br.unitins.model.Endereco;
import br.unitins.model.ItemCompra;

public record CompraResponseDTO(
    Double totalCompra,
    List<ItemCompra> itemCompra,
    Endereco endereco,
    List<Cliente> cliente,
    Comprovante comprovante
    ) {

    public CompraResponseDTO(Compra compra){
        this( compra.getTotalCompra(),
        compra.getItemCompra(),
        compra.getEndereco(),
        compra.getCliente(),
        compra.getComprovante()
        );

    }
    
}
