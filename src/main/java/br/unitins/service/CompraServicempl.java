package br.unitins.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.dto.CompraResponseDTO;
import br.unitins.dto.ItemCompraDTO;
import br.unitins.model.Compra;
import br.unitins.repository.CompraRepository;
import jakarta.inject.Inject;

public class CompraServicempl implements CompraService{

    @Inject
    CompraRepository compraRepository;

    @Override
    public List<CompraResponseDTO> getAll(Long idUsuario) {
        
        List<Compra> listaCompra = compraRepository.listAll();

        return listaCompra.stream().map(CompraResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public CompraResponseDTO getCompraEmAndamento(Long idUsuario) {
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
