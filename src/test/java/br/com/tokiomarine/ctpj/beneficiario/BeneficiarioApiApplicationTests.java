package br.com.tokiomarine.ctpj.beneficiario;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BeneficiarioApiApplicationTests {

	
	@LocalServerPort
	int port;
	
	@Before
    public void setUp() {
        RestAssured.port = port;
    }
	
	@Test
	public void contextLoads() {
	}

	@DirtiesContext
	@Test
	public void testBeneficiarioEmpty() {
		given()
			.get("/beneficiario/v1/1")
		.then()
			.statusCode(204);
	}
	
	@DirtiesContext
	@Test
	public void testBeneficiarioNotEmpty() {
		given()
			.get("/beneficiario/v1/criar")
		.then()
			.statusCode(200);

		given().port(port)
			.get("/beneficiario/v1/1")
		.then()
			.statusCode(200);
	}
	
	@DirtiesContext
	@Test
	public void testBeneficiarioPost() {
		Beneficiario b1 = new Beneficiario(38872538840L, "Fernando Pessoa", new BigDecimal("20"), null, "Complemento", "1");
		
		Response response = given()
				.contentType(ContentType.JSON)
				.body(b1)
			.when()
				.post("/beneficiario/v1");
		
		assertThat(response.getStatusCode() == 201);
	}
	
	@DirtiesContext
	@Test
	public void testBeneficiarioDelete() {
		Response response = given()
			.get("/beneficiario/v1/criar");
		
		JsonPath jsonPath = response.jsonPath();
		List<Beneficiario> beneficiarios = jsonPath.getList("", Beneficiario.class);
		
		given()
			.delete("/beneficiario/v1/{id}",beneficiarios.get(0).getId())
		.then()
			.statusCode(204);
	}
}
