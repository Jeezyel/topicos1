package br.unitins;

import static io.restassured.RestAssured.given;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import br.unitins.dto.AuthUsuarioDTO;
import br.unitins.dto.TelefoneDTO;
import br.unitins.dto.TelefoneResponseDTO;
import br.unitins.service.TelefoneService;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TelefoneTestes { 

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

    @Inject
    TelefoneService telefoneService;

    @Test
    public void testGetAll() {
        given()
                .header("Authorization", "Bearer " + token)
                .when().get("/telefone/getAll")
                .then()
                .statusCode(204);
    }

    @Test
    public void testInsert() {
        TelefoneDTO telefoneDTO = new TelefoneDTO(
                "(63)",
                "(99) 99999-9999",
                false);
        given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(telefoneDTO)
                .when().post("/telefones")
                .then()
                .statusCode(201)
                .body("id", notNullValue(),
                "codigoArea", is("(63)"),
                                             "numero", is("(99) 99999-9999"));
    }

    @Test
    public void testUpdate() {
        // Adicionando uma pessoa no banco de dados
        TelefoneDTO telefoneDTO = new TelefoneDTO(
                "(63)",
                "(99) 99999-9999",
                false);
        Long idTLong = telefoneService.create(telefoneDTO).id();
        // Criando outra pessoa para atuailzacao
        TelefoneDTO telefoneUpDto = new TelefoneDTO(
                "(63)",
                "(99) 99999-9999",
                false);
        given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(telefoneUpDto)
                .when().put("/telefones/" + idTLong)
                .then()
                .statusCode(204);
        // Verificando se os dados foram atualizados no banco de dados
        TelefoneResponseDTO estadoResponseDTO = telefoneService.findById(idTLong);
        assertThat(estadoResponseDTO.codigoDeArea(), is("(62)"));
        assertThat(estadoResponseDTO.numero(), is("(62) 11111-2222"));
    }

    @Test
    public void testDelete() {
        // Adicionando uma pessoa no banco de dados
        TelefoneDTO telefoneDTO = new TelefoneDTO(
                "(63)",
                "(99) 99999-9999",
                false);
        Long idLong = telefoneService.create(telefoneDTO).id();
        given()
                .header("Authorization", "Bearer " + token)
                .when().delete("/telefones/" + idLong)
                .then()
                .statusCode(204);
        // verificando se a pessoa fisica foi excluida
        TelefoneResponseDTO telefoneResponseDTO = null;
        try {
            telefoneService.findById(idLong);
        } catch (Exception e) {
        } finally {
            assertNull(telefoneResponseDTO);
        }
    }
}
