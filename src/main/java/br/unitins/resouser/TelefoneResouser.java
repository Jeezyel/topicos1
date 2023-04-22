package br.unitins.resouser;

import javax.ws.rs.core.MediaType;

import java.util.List;

import br.unitins.service.TelefoneService;
import com.oracle.svm.core.annotate.Inject;

import br.unitins.dto.TelefoneDTO;
import br.unitins.dto.TelefoneResponseDTO;
import br.unitins.service.TelefoneServicempl;

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
public class TelefoneResouser {
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
