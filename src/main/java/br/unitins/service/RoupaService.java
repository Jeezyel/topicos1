package br.unitins.service;

import java.util.List;

import br.unitins.dto.RoupasDTO;
import br.unitins.dto.RoupasResouserDTO;

public interface RoupaService {

    List<RoupasResouserDTO>getAll();

    RoupasResouserDTO findById(long id);

    RoupasResouserDTO create(RoupasDTO dto);

    RoupasResouserDTO updata(long id , RoupasDTO dto);

    void delete(long id);

    // extras
    
    RoupasResouserDTO findByName(String name);

    List<RoupasResouserDTO> findByNameList(String name);

    long count();


    
    
}
