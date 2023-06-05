package br.unitins.service;

import java.util.List;

import br.unitins.dto.CompraResponseDTO;
import br.unitins.dto.ItemCompraDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompraServicempl implements CompraService{

    @Override
    public List<CompraResponseDTO> getAll(Long idUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

   // dsfa

    @Override
    public CompraResponseDTO getCompraEmAndamento(String loginn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCompraEmAndamento'");
    }

    @Override
    public void insertItemIntoCompra(Long idCompra, ItemCompraDTO itemCompraDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertItemIntoCompra'");
    }

    @Override
    public void removeItemCompra(Long idUsuario, Long idItemCompra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItemCompra'");
    }

    @Override
    public void finishCompra(Long idUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finishCompra'");
    }
    
}
