package br.unitins.resouce;


import java.util.List;

import org.jboss.logging.Logger;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import br.unitins.aplication.Result;
import br.unitins.dto.MunicipioDTO;
import br.unitins.dto.MunicipioResponseDTO;
// import br.unitins.service.MunicipioService;
import br.unitins.service.MunicipioService;

@Path("/municipios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MunicipioResouce {

    private static final Logger LOG = Logger.getLogger(MunicipioResouce.class);

    @Inject
    MunicipioService municipioService;

    @GET
    @Path("/getAll")
    @RolesAllowed({"Admin"})
    public List<MunicipioResponseDTO> getAll() {
        LOG.info("buscando todos os municipios." );
        return municipioService.getAll();
    }

    @GET
    @Path("/findById/{id}")
    public MunicipioResponseDTO findById(@PathParam("id") Long id) {
        return municipioService.findById(id);
    }

    @POST
    @Path("/insert")
    @RolesAllowed({"Admin","User"})
    public Response insert(MunicipioDTO dto) {

        LOG.infof("inserindo : %s ." , dto.nome());
        try {
            MunicipioResponseDTO municipio = municipioService.create(dto);
            return Response.status(Status.CREATED).entity(municipio).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/update/{id}")
    @RolesAllowed({"Admin","User"})
    public Response update(@PathParam("id") Long id, MunicipioDTO dto) {
        try {
            MunicipioResponseDTO municipio = municipioService.update(id, dto);
            return Response.ok(municipio).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }      
    }

    @DELETE
    @Path("/DeleteForId/{Id}")
    @RolesAllowed({"Admin"})
    public void DeleteForId(@PathParam("Id") long id){
        municipioService.delete(id);
    }


    @GET
    @Path("/count")
    @RolesAllowed({"Admin"})
    public long count(){
        return municipioService.count();
    }

    @GET
    @Path("/search/{nome}")
    @RolesAllowed({"Admin","User"})
    public List<MunicipioResponseDTO> search(@PathParam("nome") String nome){
        return municipioService.findByNome(nome);
        
    }
}
