package com.example.springbootconditionalapp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringbootConditionalAppApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;

    //define container one
    public static GenericContainer<?> devApp = new GenericContainer<>("devapp")
            .withExposedPorts(8080);

    //define container two
    public static GenericContainer<?> prodApp = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        //start containers
        devApp.start();
        prodApp.start();
    }

    @Test
    void contextLoadsDevapp() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(
                "http://localhost:" + devApp.getMappedPort(8080) + "/profile", String.class);
        assertEquals(forEntity.getBody(), "Current profile is dev");
    }

    @Test
    void contextLoadsProdapp() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(
                "http://localhost:" + prodApp.getMappedPort(8081) + "/profile", String.class);
        assertEquals(forEntity.getBody(), "Current profile is production");
    }
}
