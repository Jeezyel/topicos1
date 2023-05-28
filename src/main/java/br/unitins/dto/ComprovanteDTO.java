package br.unitins.dto;

import java.util.List;

import br.unitins.model.Compra;
import br.unitins.model.ItemCompra;

public record ComprovanteDTO(
    Compra compra,
    long id,
    String nomePagador,
    String nomeUsuario,
    String cpfpagador,
    List<ItemCompra> itemCompra
) {
    
}
