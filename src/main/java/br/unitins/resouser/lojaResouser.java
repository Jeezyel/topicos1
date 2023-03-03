package br.unitins.resouser;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import br.unitins.model.Roupas;
import br.unitins.repository.RoupasRepository;

import java.util.List;

@Path("/Loja")
public class lojaResouser {

    @Inject
    private RoupasRepository repository;

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Roupas> getAll(){

        return repository.findAll().list();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Roupas addList(Roupas roupas){
        roupas.persist();

        return roupas;

    }

    @PATCH
    @Path("/{ID}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Roupas att (@PathParam("/ID") Long ID , Roupas roupas ){
        Roupas r2 = repository.findById(ID);
        r2.setCor(roupas.getCor());
        r2.setMarca(roupas.getMarca());

        return r2;
    }

    @DELETE
    @Path("/{ID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Roupas deleteRoupas(@PathParam("ID") Long ID , Roupas roupas){
        Roupas r2 = repository.findById(ID);

        r2.delete();

        return r2;

    }


    @DELETE
    @Path("/{nameMarca}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Roupas DeletForName(@PathParam("nameMarca") String marca ){
        Roupas roupaForDelet = repository.findByMarca(marca);
        return roupaForDelet ;
    }
}
