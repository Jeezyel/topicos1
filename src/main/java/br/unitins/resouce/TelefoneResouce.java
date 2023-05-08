package br.unitins.resouce;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

import br.unitins.service.TelefoneService;


import br.unitins.dto.TelefoneDTO;
import br.unitins.dto.TelefoneResponseDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

//Resouce

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TelefoneResouce {

    @Inject
    private TelefoneService service;


    @GET
    @Path("/gatAll")
    public List<TelefoneResponseDTO> getAll(){
        return service.getAll();
    }

    @GET
    @Path("/searchForId/{Id}")
    public TelefoneResponseDTO searchForId(@PathParam("Id") Long Id){
        return service.findById(Id);
    }

    // create
    @POST
    @Path("/insert")
    @Transactional
    public TelefoneResponseDTO insert(TelefoneDTO telefoneDTO) {
        
        return service.create(telefoneDTO);
    }
    // update
    @POST
    @Path("/update/{id}")
    @Transactional
    public TelefoneResponseDTO update(@PathParam("id") Long id, TelefoneDTO telefoneDTO) {
        
        return service.update(id , telefoneDTO);
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
    public List<TelefoneResponseDTO> searchForName(@PathParam("name") String name){
        return service.findByNome(name);
    }
}
