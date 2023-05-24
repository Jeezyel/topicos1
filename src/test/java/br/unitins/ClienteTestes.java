package br.unitins;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import br.unitins.dto.ClienteDTO;
import br.unitins.dto.EnderecoDTO;
import br.unitins.dto.TelefoneDTO;
import br.unitins.service.ClienteService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
public class ClienteTestes {

  @Inject
  ClienteService service;


  @Test
  public void getAllTeste(){

    given().when().get("/cliente/getAll").then().statusCode(200);

  }

  @Test
  public void CountTeste(){

    given().when().get("/cliente/count").then().statusCode(200);

  }

  @Test
  public void insertTest(){
    EnderecoDTO endereco = new EnderecoDTO("23412431", "null", "null", "null", 1);


    TelefoneDTO telefone = new TelefoneDTO(2, "45", "254373456", false);

    ClienteDTO cliente = new ClienteDTO(5, "2345234523", "null", endereco, telefone, "null", "null", "null", "null");

    given().contentType(ContentType.JSON).body(cliente).when().post("/cliente/insert")
    .then().statusCode(201);
  }

    

    
}
