package br.unitins.dto;

import java.util.List;

import br.unitins.model.Cliente;

public record CompraDTO(
    Double totalCompra,
    List<ItemCompraDTO> itemCompra,
    List<EnderecoDTO> endereco,
    List<Cliente> cliente
) {

    

    
    
}
