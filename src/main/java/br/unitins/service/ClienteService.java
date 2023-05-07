package br.unitins.service;

import java.util.List;

import br.unitins.dto.ClienteDTO;
import br.unitins.dto.ClienteResponseDTO;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ClienteService {

    // recursos basicos
    List<ClienteResponseDTO> getAll();

    ClienteResponseDTO findById(Long id);

    ClienteResponseDTO create(ClienteDTO clienteDTO);

    ClienteResponseDTO update(Long id, ClienteDTO clienteDTO);

    void delete(Long id);

    // recursos extras

    List<ClienteResponseDTO> findByNome(String nome);

    long count();
    
}
