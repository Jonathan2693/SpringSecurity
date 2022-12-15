package com.openbootcamp.ejercicio789;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.openbootcamp.ejercicio789.entities.Laptop;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	@LocalServerPort
	private int port;
	
	@BeforeEach
	void setUp() {
		restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
		System.out.println(restTemplateBuilder.toString());
		testRestTemplate = new TestRestTemplate();
	}
	
	@Test
	void findAllTest() {
		ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("http://localhost:" + port + "/laptop/all", Laptop[].class);
		assertEquals(response.getStatusCodeValue(), 204);
		assertNull(response.getBody());
	}
	
	@Test
	void findByIdTest() {
		ResponseEntity<String> response = testRestTemplate.getForEntity("http://localhost:" + port + "/laptop/1", String.class);
		assertEquals(response.getStatusCodeValue(), 204);
		assertNull(response.getBody());
	}
	
	@Test
	void createTest() throws JSONException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String json = new JSONObject()
                .put("marca", "HP")
                .put("memoria", "512 GB SSD")
                .toString();
		HttpEntity<String> request = new HttpEntity<String>(json,headers);
		ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:" + port + "/laptop", HttpMethod.POST,request,String.class);
		assertEquals(response.getStatusCodeValue(), 200);
		assertNotNull(response.getBody());
	}
	
	@Test
	void updateTest() throws JSONException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String json = new JSONObject()
				.put("id", 10)
                .put("marca", "HP mod")
                .put("memoria", "512 GB SSD mod")
                .toString();
		HttpEntity<String> request = new HttpEntity<String>(json,headers);
		ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:" + port + "/laptop/update", HttpMethod.PUT,request,String.class);
		assertEquals(response.getStatusCodeValue(), 404);
	}

}
