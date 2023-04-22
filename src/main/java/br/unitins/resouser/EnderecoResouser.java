package br.unitins.resouser;

import javax.ws.rs.core.MediaType;

import java.util.List;

import com.oracle.svm.core.annotate.Inject;

import br.unitins.dto.EnderecoDTO;
import br.unitins.dto.EnderecoResponseDTO;
import br.unitins.service.EnderecoServicempl;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/endereco")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoResouser {
    @Inject
    private EnderecoServicempl service;


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
    public List<EnderecoResponseDTO> searchForName(@PathParam("name") String name){
        return service.findByNome(name);
    }
}
