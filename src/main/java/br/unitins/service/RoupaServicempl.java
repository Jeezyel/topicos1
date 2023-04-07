package br.unitins.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.NotFoundException;

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


		//RoupasResouserDTO roupas = roupasRepository.findById(id);
		Roupas roupas = roupasRepository.findById(id);
		
		if(roupas == null)
			throw new NotFoundException("Roupa nao encontrada");
		return new RoupasResouserDTO(roupas);
	}

	@Override
	public RoupasResouserDTO create(RoupasDTO dto) throws ConstraintViolationException {

		if(dto == null){
			return null;
		}

		Roupas entity = new Roupas();
        entity.setValor(dto.getValor());
        entity.setCor(dto.getCor());
        entity.setMarca(dto.getMarca());
        entity.setModelo(dto.getModelo());

		roupasRepository.persist(entity);
		return new RoupasResouserDTO(entity);
	}

	@Override
	public RoupasResouserDTO updata(long id, RoupasDTO dto) throws ConstraintViolationException {
		Roupas newRoupa = roupasRepository.findById(id);
        newRoupa.setValor(dto.getValor());
        newRoupa.setCor(dto.getCor());
        newRoupa.setMarca(dto.getMarca());
        newRoupa.setModelo(dto.getModelo());

        return  new RoupasResouserDTO(newRoupa);
	}

	@Override
	public void delete(long id) {
		Roupas roupa = roupasRepository.findById(id);

		if( roupa == null )
			throw new UnsupportedOperationException("Nao pode encontra por id");

		roupasRepository.delete(roupa);
	}

	@Override
	public RoupasResouserDTO findByName(String name) {
		Roupas roupas = roupasRepository.findByMarca(name);

		return new RoupasResouserDTO(roupas);
	}

	@Override
	public List<RoupasResouserDTO> findByNameList(String name) {
		List<Roupas> listaRoupa = roupasRepository.findByMarcaList(name);

		return listaRoupa.stream().map(RoupasResouserDTO::new).collect(Collectors.toList());
		
	}

	@Override
	public long count() {
		return roupasRepository.count();
	}

	
    
}
