package br.unitins.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.NotFoundException;

import br.unitins.dto.RoupasDTO;
import br.unitins.dto.RoupasResponseDTO;
import br.unitins.model.Roupas;
import br.unitins.repository.RoupasRepository;

@ApplicationScoped
public class RoupaServicempl implements RoupaService {

    @Inject
    private RoupasRepository roupasRepository;


	@Override
	public List<RoupasResponseDTO> getAll() {
        List<Roupas> listaRoupas = roupasRepository.listAll();

        return listaRoupas.stream().map(RoupasResponseDTO::new).collect(Collectors.toList());
		
	}

	@Override
	public RoupasResponseDTO findById(long id) {


		//RoupasResouserDTO roupas = roupasRepository.findById(id);
		Roupas roupas = roupasRepository.findById(id);
		
		if(roupas == null)
			throw new NotFoundException("Roupa nao encontrada");
		return new RoupasResponseDTO(roupas);
	}

	@Override
	public RoupasResponseDTO create(RoupasDTO dto) throws ConstraintViolationException {

		if(dto == null){
			return null;
		}

		Roupas entity = new Roupas();
        entity.setValor(dto.getValor());
        entity.setCor(dto.getCor());
        entity.setMarca(dto.getMarca());
        entity.setModelo(dto.getModelo());

		roupasRepository.persist(entity);
		return new RoupasResponseDTO(entity);
	}

	@Override
	public RoupasResponseDTO updata(long id, RoupasDTO dto) throws ConstraintViolationException {
		Roupas newRoupa = roupasRepository.findById(id);
        newRoupa.setValor(dto.getValor());
        newRoupa.setCor(dto.getCor());
        newRoupa.setMarca(dto.getMarca());
        newRoupa.setModelo(dto.getModelo());

        return  new RoupasResponseDTO(newRoupa);
	}

	@Override
	public void delete(long id) {
		Roupas roupa = roupasRepository.findById(id);

		if( roupa == null )
			throw new UnsupportedOperationException("Nao pode encontra por id");

		roupasRepository.delete(roupa);
	}

	@Override
	public RoupasResponseDTO findByName(String name) {
		Roupas roupas = roupasRepository.findByMarca(name);

		return new RoupasResponseDTO(roupas);
	}

	@Override
	public List<RoupasResponseDTO> findByNameList(String name) {
		List<Roupas> listaRoupa = roupasRepository.findByMarcaList(name);

		return listaRoupa.stream().map(RoupasResponseDTO::new).collect(Collectors.toList());
		
	}

	@Override
	public long count() {
		return roupasRepository.count();
	}

	
    
}
