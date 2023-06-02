package br.unitins.dto;

import java.util.List;

import br.unitins.model.Cliente;
import br.unitins.model.Comprovante;
import br.unitins.model.Usuario;

public record CompraDTO(
    long id,
    Double totalCompra,
    List<ItemCompraDTO> itemCompra,
    List<EnderecoDTO> endereco,
    List<Cliente> cliente,
    Comprovante comprovante,
    Usuario usuario
) {

    

    
    
}
