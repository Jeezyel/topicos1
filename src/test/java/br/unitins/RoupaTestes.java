package br.unitins;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.unitins.dto.AuthUsuarioDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;

@QuarkusTest
public class RoupaTestes {
  private String token;

    @BeforeEach
    public void setUp(){
        var auth = new AuthUsuarioDTO("goku", "123");

        Response response = (Response) given()
                .contentType("application/json")
                .body(auth)
                .when().post("/auth")
                .then()
                .statusCode(200)
                .extract().response();
        
        token = response.header("Authorization");
    }
    

    @Test
    public void gatAllTeste(){

        given()
          .when().get("/Loja/getAll")
          .then()
             .statusCode(200);

    }

    @Test
    public void CountTeste(){

        given()
          .when().get("/Loja/count")
          .then()
            .statusCode(200);

    }
    
}
