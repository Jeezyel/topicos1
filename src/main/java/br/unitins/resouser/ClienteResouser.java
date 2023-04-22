package br.unitins.resouser;

import javax.ws.rs.core.MediaType;

import java.util.List;

import br.unitins.service.ClienteService;
import com.oracle.svm.core.annotate.Inject;

import br.unitins.dto.ClienteDTO;
import br.unitins.dto.ClienteResponseDTO;
import br.unitins.service.ClienteServicempl;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResouser {
    @Inject
    private ClienteService service;


    @GET
    @Path("/gatAll")
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
