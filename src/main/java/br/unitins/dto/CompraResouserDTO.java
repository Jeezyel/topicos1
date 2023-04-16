package br.unitins.dto;

import java.util.Date;
import java.util.List;

import br.unitins.model.Compra;
import net.bytebuddy.build.Plugin;

public record CompraResouserDTO(
    Date data,
    Double totalCompra,
    List<ItemCompraDTO> itemCompra,
    List<EnderecoDTO> endereco) {

    public CompraResouserDTO(Compra compra){
        this(compra.data(), compra.totalCompra(), compra.itemCompra(), compra.endereco());

    }
    
}
