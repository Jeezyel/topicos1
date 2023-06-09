package br.unitins.dto;

import br.unitins.model.Compra;
import br.unitins.model.Pagamento;
import br.unitins.model.TipoPagamento;

public record PagamentoResponseDTO(
    Compra compra,
    Integer quantidadeParcela ,
    Double valorParcela,
    TipoPagamento tipoPagamento,
    Boolean confirmarPagamento
    ) {
    PagamentoResponseDTO(Pagamento pagamento){
        this(pagamento.getCompra(),
        pagamento.getQuantidadeParcela(),
        pagamento.getValorParcela(),
        pagamento.getTipoPagamento(),
        pagamento.getConfirmarPagamento()
        );
    }
        
    
}
