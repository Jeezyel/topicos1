package br.unitins.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.NotFoundException;

import br.unitins.dto.RoupasDTO;
import br.unitins.dto.RoupasResponseDTO;
import br.unitins.model.Roupa;
import br.unitins.repository.RoupasRepository;

@ApplicationScoped
public class RoupaServicempl implements RoupaService {

    @Inject
    private RoupasRepository roupasRepository;


	@Override
	public List<RoupasResponseDTO> getAll() {
        List<Roupa> listaRoupas = roupasRepository.listAll();

        return listaRoupas.stream().map(RoupasResponseDTO::new).collect(Collectors.toList());
		
	}

	@Override
	public RoupasResponseDTO findById(long id) {


		//RoupasResouserDTO roupas = roupasRepository.findById(id);
		Roupa roupas = roupasRepository.findById(id);
		
		if(roupas == null)
			throw new NotFoundException("Roupa nao encontrada");
		return new RoupasResponseDTO(roupas);
	}

	@Override
	public RoupasResponseDTO create(RoupasDTO dto) throws ConstraintViolationException {

		if(dto == null){
			return null;
		}

		Roupa entity = new Roupa();
        entity.setValor(dto.getValor());
        entity.setCor(dto.getCor());
        entity.setMarca(dto.getMarca());
        entity.setModelo(dto.getModelo());

		roupasRepository.persist(entity);
		return new RoupasResponseDTO(entity);
	}

	@Override
	public RoupasResponseDTO update(long id, RoupasDTO dto) throws ConstraintViolationException {
		Roupa newRoupa = roupasRepository.findById(id);
        newRoupa.setValor(dto.getValor());
        newRoupa.setCor(dto.getCor());
        newRoupa.setMarca(dto.getMarca());
        newRoupa.setModelo(dto.getModelo());

        return  new RoupasResponseDTO(newRoupa);
	}

	@Override
	public void delete(long id) {
		Roupa roupa = roupasRepository.findById(id);

		if( roupa == null )
			throw new UnsupportedOperationException("Nao pode encontra por id");

		roupasRepository.delete(roupa);
	}

	@Override
	public RoupasResponseDTO findByName(String name) {
		Roupa roupas = roupasRepository.findByMarca(name);

		return new RoupasResponseDTO(roupas);
	}

	@Override
	public List<RoupasResponseDTO> findByNameList(String name) {
		List<Roupa> listaRoupa = roupasRepository.findByMarcaList(name);

		return listaRoupa.stream().map(RoupasResponseDTO::new).collect(Collectors.toList());
		
	}

	@Override
	public long count() {
		return roupasRepository.count();
	}

	@Override
	public Roupa updateNomeImagerRoupa(Long idRoupa, String nomeImagen) {
		Roupa roupa = roupasRepository.findByID(idRoupa);
		
		roupa.setNomeImagen(nomeImagen);

		roupasRepository.persist(roupa);

		return roupa;
	}

	
    
}
