package br.unitins.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.unitins.dto.RoupasDTO;
import br.unitins.dto.RoupasResouserDTO;
import br.unitins.model.Roupas;
import br.unitins.repository.RoupasRepository;

@ApplicationScoped
public class RoupaServicempl implements RoupaService {

    @Inject
    private RoupasRepository roupasRepository;


	@Override
	public List<RoupasResouserDTO> getAll() {
        List<Roupas> listaRoupas = roupasRepository.listAll();

        return listaRoupas.stream().map(RoupasResouserDTO::new).collect(Collectors.toList());
		
	}

	@Override
	public RoupasResouserDTO findById(long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findById'");
	}

	@Override
	public RoupasResouserDTO create(RoupasDTO dto) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'create'");
	}

	@Override
	public RoupasResouserDTO updata(long id, RoupasDTO dto) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updata'");
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	@Override
	public List<RoupasResouserDTO> findByName(String name) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findByName'");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'count'");
	}
    
}
