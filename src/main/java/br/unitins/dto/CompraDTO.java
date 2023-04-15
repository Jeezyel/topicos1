package br.unitins.dto;

import java.util.Date;
import java.util.List;

public record CompraDTO(
    
    Date data,
    Double totalCompra,
    List<ItemCompraDTO> itemCompra,
    List<EnderecoDTO> endereco
) {

    

    
    
}
