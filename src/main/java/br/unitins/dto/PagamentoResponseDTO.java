package br.unitins.dto;

import br.unitins.model.Compra;
import br.unitins.model.Pagamento;
import br.unitins.model.TipoPagamento;

public record PagamentoResponseDTO(
    long id,
    Compra compra,
    Integer quantidadeParcela ,
    Double valorParcela,
    TipoPagamento tipoPagamento,
    Boolean confirmarPagamento
    ) {
    public PagamentoResponseDTO(Pagamento pagamento){
        this(pagamento.getId(),
            pagamento.getCompra(),
            pagamento.getQuantidadeParcela(),
            pagamento.getValorParcela(),
            pagamento.getTipoPagamento(),
            pagamento.getConfirmarPagamento()
        );
    }
        
    
}
