package br.unitins.service;

import java.util.List;

import br.unitins.dto.CompraResponseDTO;
import br.unitins.dto.ItemCompraDTO;


public interface CompraService {

    public List<CompraResponseDTO> getAll (Long idUsuario);

    public CompraResponseDTO getCompraEmAndamento (String loginn);
    
    public void insertItemIntoCompra (Long idCompra, ItemCompraDTO itemCompraDTO);

    public void removeItemCompra (Long idUsuario, Long idItemCompra);

    public void finishCompra (Long idUsuario);
}
