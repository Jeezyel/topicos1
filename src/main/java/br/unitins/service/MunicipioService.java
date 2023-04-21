package br.unitins.service;

import java.util.List;

import br.unitins.dto.MunicipioDTO;
import br.unitins.dto.MunicipioResponseDTO;

public interface MunicipioService {




    // recursos basicos
    List<MunicipioResponseDTO> getAll();

    MunicipioResponseDTO findById(Long id);

    MunicipioResponseDTO create(MunicipioDTO municipioDTO);

    MunicipioResponseDTO update(Long id, MunicipioDTO municipioDTO);

    void delete(Long id);

    // recursos extras

    List<MunicipioResponseDTO> findByNome(String nome);

    long count();

    
}
