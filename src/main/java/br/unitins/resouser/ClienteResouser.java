package br.unitins.resouser;

import javax.ws.rs.core.MediaType;

import java.util.List;

import com.oracle.svm.core.annotate.Inject;

import br.unitins.dto.ClienteResponseDTO;
import br.unitins.service.ClienteServicempl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/estados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResouser {
    @Inject
    private ClienteServicempl service;


    @GET
    public List<ClienteResponseDTO> getAll(){
        return service.getAll();
    }

    @GET
    @Path("/searchForId/{Id}")
    public ClienteResponseDTO searchForId(@PathParam("Id") Long Id){
        return service.findById(Id);
    }

    // create
    
    // update

    @GET
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
