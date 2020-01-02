package com.sample.zoorestservice.integration;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.sample.zoorestservice.repo.ShowRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecurityTest {
    private final String postShowBody =
            "{\"showId\":\"d290f1ee-6c54-4b01-90e6-d701748f0852\",\"name\":\"seagulls feeding\",\"schedule\":\"monday 12:00\"}";

    @LocalServerPort
    private int port;

    @Autowired
    private ShowRepository showRepository;

    @Test
    public void unauthorizedAccessTest() {
        int recordsNumber = showRepository.findAll().size();
        Response response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(postShowBody)
                .port(port)
                .post("/admin/shows");

        assertThat("Status code is 401", response.statusCode(), is(401));
        assertThat("Nothing was added in db", showRepository.findAll().size(), is(recordsNumber));
    }

    @Test
    public void authorizedAccessTest() {
        int recordsNumber = showRepository.findAll().size();
        Response response = RestAssured.given().log().everything()
                .auth().basic("memuser", "pass")
                .contentType(ContentType.JSON)
                .body(postShowBody)
                .port(port)
                .post("/admin/shows");

        assertThat("Status code is 200", response.statusCode(), is(200));
        assertThat("One record was added in db", showRepository.findAll().size(), is(recordsNumber + 1));
    }

    @Test
    public void permitAllTest(){
        Response response = RestAssured.given().log().everything()
                .port(port)
                .contentType(ContentType.JSON)
                .get("/shows");

        assertThat("Status code is 200", response.statusCode(), is(200));
    }
}
