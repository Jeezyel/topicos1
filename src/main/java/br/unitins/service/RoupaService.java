package br.unitins.service;

import java.util.List;

import br.unitins.dto.RoupasDTO;
import br.unitins.dto.RoupasResponseDTO;
import br.unitins.model.Roupa;

public interface RoupaService {

    List<RoupasResponseDTO>getAll();

    RoupasResponseDTO findById(long id);

    RoupasResponseDTO create(RoupasDTO dto);

    RoupasResponseDTO update(long id , RoupasDTO dto);

    void delete(long id);
    
    Roupa updateNomeImagerRoupa(Long id, String nomeImagen);

    // extras
    
    RoupasResponseDTO findByName(String name);

    List<RoupasResponseDTO> findByNameList(String name);

    long count();


    
    
}
