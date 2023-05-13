package br.unitins.resouce;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

import br.unitins.service.ClienteService;
import jakarta.inject.Inject;

import br.unitins.dto.ClienteDTO;
import br.unitins.dto.ClienteResponseDTO;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResouce {

    @Inject
    ClienteService service;


    @GET
    @Path("/getAll")
    public List<ClienteResponseDTO> getAll(){
        return service.getAll();
    }

    @GET
    @Path("/searchForId/{Id}")
    public ClienteResponseDTO searchForId(@PathParam("Id") Long Id){
        return service.findById(Id);
    }

    // create
    @POST
    @Path("/insert")
    @Transactional
    public ClienteResponseDTO insert(ClienteDTO clienteDTO) {
        
        return service.create(clienteDTO);
    }
    // update
    @POST
    @Path("/update/{id}")
    @Transactional
    public ClienteResponseDTO update(@PathParam("id") Long id, ClienteDTO clienteDTO) {
        
        return service.update(id , clienteDTO);
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
    public List<ClienteResponseDTO> searchForName(@PathParam("name") String name){
        return service.findByNome(name);
    }

    
}
