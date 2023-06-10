package br.unitins.service;

import java.util.List;

import br.unitins.dto.CompraResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public interface CompraService {

    public List<CompraResponseDTO> getAll (Long idUsuario);

    public CompraResponseDTO getCompraEmAndamento (String loginn);
    
    public void insertItemIntoCompra (Long idCompra, long idRoupa);

    public void removeItemCompra (Long idUsuario, long idRoupa);

}
