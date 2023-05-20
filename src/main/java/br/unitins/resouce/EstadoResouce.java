package br.unitins.resouce;


import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import br.unitins.dto.EstadosDTO;
import br.unitins.dto.EstadosResponseDTO;
import br.unitins.model.Estados;
import br.unitins.repository.EstadoRepository;
import br.unitins.service.EstadoService;



@Path("/estados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstadoResouce {

    @Inject
    private EstadoRepository repository;

    @Inject
    private EstadoService service;

    @GET
    @Path("/getAll")
    public List<EstadosResponseDTO> getAll() {
        
        // seleciona todas as Estados do banco de dados
         return service.getAll();

    }

    @POST
    @Path("/insert/{estado}")
    @Transactional
    public EstadosResponseDTO insert(EstadosDTO estado) {
        
        return service.create(estado);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Estados update(@PathParam("id") Long id, Estados estado) {

        Estados entity = repository.findById(id);

         entity.setNome(estado.getNome());
         entity.setSigla(estado.getSigla());

        return entity;
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    public void DeleteForId(@PathParam("Id") long id){
        service.delete(id);
    }

    @GET
    @Path("/count")
    public long count(){
        return repository.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<Estados> search(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }
}
