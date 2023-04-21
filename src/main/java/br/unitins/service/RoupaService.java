package br.unitins.service;

import java.util.List;

import br.unitins.dto.RoupasDTO;
import br.unitins.dto.RoupasResponseDTO;

public interface RoupaService {

    List<RoupasResponseDTO>getAll();

    RoupasResponseDTO findById(long id);

    RoupasResponseDTO create(RoupasDTO dto);

    RoupasResponseDTO updata(long id , RoupasDTO dto);

    void delete(long id);

    // extras
    
    RoupasResponseDTO findByName(String name);

    List<RoupasResponseDTO> findByNameList(String name);

    long count();


    
    
}
