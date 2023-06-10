package br.unitins.service;

import java.util.List;

import br.unitins.dto.PagamentoDTO;
import br.unitins.dto.PagamentoResponseDTO;

public interface pagamentoService {

    PagamentoResponseDTO create(PagamentoDTO pagamento);

    PagamentoResponseDTO finalizarCompra(long id);

    PagamentoResponseDTO findById(Long id);
    
    List<PagamentoResponseDTO> getAll();

    long count();
}
