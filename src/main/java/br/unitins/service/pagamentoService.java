package br.unitins.service;

import java.util.List;

import br.unitins.aplication.Result;
import br.unitins.model.Pagamento;

public interface pagamentoService {
    public Pagamento create(Pagamento pagamento);

    public Result finalizarCompra();

    
    List<pagamentoRespon> getAll();
}
