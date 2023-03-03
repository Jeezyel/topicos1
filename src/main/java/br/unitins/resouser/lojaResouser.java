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
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
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
    @Transactional
    public Roupas addList(Roupas roupas){
        roupas.persist();

        return roupas;

    }

    @PATCH
    @Path("/{ID}")
    @Transactional
    public Roupas att (@PathParam("/ID") Long ID , Roupas roupas ){
        Roupas r2 = repository.findById(ID);
        r2.setCor(roupas.getCor());
        r2.setMarca(roupas.getMarca());

        return r2;
    }

    @DELETE
    @Path("/{ID}")
    @Transactional
    public Roupas deleteRoupas(@PathParam("ID") Long ID , Roupas roupas){
        Roupas r2 = repository.findById(ID);

        r2.delete();

        return r2;

    }


    @GET
    @Path("/{nameMarca}")
    public Roupas searchForName(@PathParam("nameMarca") String marca){

        Roupas roupaForSearch = (Roupas) repository.findeByName(marca);
        return roupaForSearch;

    }

    @DELETE
    @Path("/{nameMarca}")
    @Transactional
    public Roupas DeletForName(@PathParam("nameMarca") String marca ){
        Roupas roupaForDelet = repository.findByMarca(marca);
        return roupaForDelet ;
    }
}
