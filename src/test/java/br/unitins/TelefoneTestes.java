package br.unitins;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;


@QuarkusTest
public class TelefoneTestes {

    @Test
    public void getAllTeste (){
        given()
            .when().get("/telefone/gatAll")
            .then()
                .statusCode(200);
    }

    @Test
    public void CountTeste(){

        given()
          .when().get("/telefone/count")
          .then()
            .statusCode(200);

    }
    
}
