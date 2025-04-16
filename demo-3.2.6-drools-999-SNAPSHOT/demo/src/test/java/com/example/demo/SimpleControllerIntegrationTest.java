package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void helloEndpointIntegrationTest() {
		// Call the /hello endpoint using TestRestTemplate.
		ResponseEntity<String> response = restTemplate.getForEntity("/hello", String.class);

		// Verify that the response status is OK and the response body is as expected.
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("John is adult : true", response.getBody());
	}
}