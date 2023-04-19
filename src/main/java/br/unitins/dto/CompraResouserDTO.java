package br.unitins.dto;

import java.util.Date;
import java.util.List;

import br.unitins.model.Compra;
import br.unitins.model.Endereco;
import br.unitins.model.ItemCompra;

public record CompraResouserDTO(
    Date data,
    Double totalCompra,
    List<ItemCompra> itemCompra,
    List<Endereco> endereco) {

    public CompraResouserDTO(Compra compra){
        this(compra.getData(), compra.getTotalCompra(), compra.getItemCompra(), compra.getEndereco());

    }
    
}
