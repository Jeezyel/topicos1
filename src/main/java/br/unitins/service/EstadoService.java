package br.unitins.service;


import java.util.List;

import br.unitins.dto.EstadosDTO;
import br.unitins.dto.EstadosResouserDTO;

public interface EstadoService {


    // recursos basicos
    List<EstadosResouserDTO> getAll();

    EstadosResouserDTO findById(Long id);

    EstadosResouserDTO create(EstadosDTO estadosDTO);

    EstadosResouserDTO update(Long id, EstadosDTO estadosDTO);

    void delete(Long id);

    // recursos extras

    List<EstadosResouserDTO> findByNome(String nome);

    long count();
}
