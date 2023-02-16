package br.unitins.resouser;

import javax.ws.rs.Produces;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.unitins.model.Roupas;

import java.util.List;

@Path("/Loja")
public class lojaResouser {
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Roupas> getAll(){

        return Roupas.findAll().list();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Roupas addList(Roupas roupas){
        roupas.persist();

        return roupas;

    }
    
}
