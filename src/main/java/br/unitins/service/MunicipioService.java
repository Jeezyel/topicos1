package br.unitins.service;

import java.util.List;

import br.unitins.dto.MunicipioDTO;
import br.unitins.dto.MunicipioResouserDTO;

public interface MunicipioService {




    // recursos basicos
    List<MunicipioResouserDTO> getAll();

    MunicipioResouserDTO findById(Long id);

    MunicipioResouserDTO create(MunicipioDTO municipioDTO);

    MunicipioResouserDTO update(Long id, MunicipioDTO municipioDTO);

    void delete(Long id);

    // recursos extras

    List<MunicipioResouserDTO> findByNome(String nome);

    long count();

    
}
