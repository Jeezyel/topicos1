package br.unitins.service;


import java.util.List;

import br.unitins.dto.EstadosDTO;
import br.unitins.dto.EstadosResponseDTO;

public interface EstadoService {


    // recursos basicos
    List<EstadosResponseDTO> getAll();

    EstadosResponseDTO findById(Long id);

    EstadosResponseDTO create(EstadosDTO estadosDTO);

    EstadosResponseDTO update(Long id, EstadosDTO estadosDTO);

    void delete(Long id);

    // recursos extras

    List<EstadosResponseDTO> findByNome(String nome);

    long count();
}
