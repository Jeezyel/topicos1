package br.unitins.dto;

import java.util.Date;
import java.util.List;

public record CompraDTO(
    long id,
    Date data,
    Double totalCompra,
    List<ItemCompraDTO> itemCompra,
    List<EnderecoDTO> endereco
) {

    

    
    
}
