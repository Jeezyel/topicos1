package br.unitins.resouce;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

import br.unitins.service.EnderecoService;
import jakarta.inject.Inject;

import br.unitins.dto.EnderecoDTO;
import br.unitins.dto.EnderecoResponseDTO;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/endereco")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoResouce {
    @Inject
    private EnderecoService service;


    @GET
    @Path("/gatAll")
    public List<EnderecoResponseDTO> getAll(){
        return service.getAll();
    }

    @GET
    @Path("/searchForId/{Id}")
    public EnderecoResponseDTO searchForId(@PathParam("Id") Long Id){
        return service.findById(Id);
    }

    // create
    @POST
    @Path("/insert")
    @Transactional
    public EnderecoResponseDTO insert(EnderecoDTO enderecoDTO) {
        
        return service.create(enderecoDTO);
    }
    // update
    @POST
    @Path("/update/{id}")
    @Transactional
    public EnderecoResponseDTO update(@PathParam("id") Long id, EnderecoDTO enderecoDTO) {
        
        return service.update(id , enderecoDTO);
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    public void DeleteForId(@PathParam("Id") long id){
        service.delete(id);
    }

    @GET
    @Path("/count")
    public long count(){
        return service.count();
    }

    @GET
    @Path("/searchForName/{name}")
    public List<EnderecoResponseDTO> searchForName(@PathParam("name") String name){
        return service.findByNome(name);
    }
}
