package br.unitins;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
    
@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
   /*  public String resposta (Integer idade ){

        if(idade >= 18){
            if(idade >= 50){
                return "nossa como vc e velho ";
            }
            return "ja pode ser praso ";
        }
        else{
            return"esta na hora de nene esta na cama";
        }
    }*/
}