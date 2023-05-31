package br.unitins.service;

import java.util.List;

import br.unitins.dto.CompraResponseDTO;
import br.unitins.dto.ItemCompraDTO;


public interface CompraService {

    List<CompraResponseDTO> getAll (Long idUsuario);

    CompraResponseDTO getCompraEmAndamento (String loginn);
    
    void insertItemIntoCompra (Long idCompra, ItemCompraDTO itemCompraDTO);

    void removeItemCompra (Long idUsuario, Long idItemCompra);

    void finishCompra (Long idUsuario);
}
