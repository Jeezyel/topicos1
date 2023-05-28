package br.unitins.dto;

import java.util.List;

import br.unitins.model.Compra;
import br.unitins.model.Comprovante;
import br.unitins.model.ItemCompra;

public record ComprovanteReponseDTO(
    Compra compra,
    String nomePagador,
    String nomeUsuario,
    String cpfpagador
   // List<ItemCompra> itemCompra
) {
    public ComprovanteReponseDTO (Comprovante comprovante){
        this(comprovante.getCompra(), comprovante.getNomePagador(),comprovante.getNomeUsuario(), comprovante.getCpfpagador()/* ,comprovante.getItemCompra()*/);
    }
    
}
