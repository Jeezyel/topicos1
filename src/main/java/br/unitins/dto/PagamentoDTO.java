package br.unitins.dto;

import br.unitins.model.Compra;
import br.unitins.model.TipoPagamento;

public record PagamentoDTO(
    Compra compra,
    Integer quantidadeParcela ,
    Double valorParcela,
    TipoPagamento tipoPagamento,
    Boolean confirmarPagamento
    ) {
    
}
