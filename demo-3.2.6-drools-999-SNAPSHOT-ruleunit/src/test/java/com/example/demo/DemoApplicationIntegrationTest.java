package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(
        classes = DemoApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class DemoApplicationIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        // If the application fails to start, this will fail
    }

    @Test
    void helloEndpointReturnsHello() {
        String url = "http://localhost:" + port + "/hello";
        ResponseEntity<String> resp = restTemplate.getForEntity(url, String.class);

        assertEquals(200, resp.getStatusCodeValue());
        assertEquals("John is adult : true", resp.getBody());
    }
}