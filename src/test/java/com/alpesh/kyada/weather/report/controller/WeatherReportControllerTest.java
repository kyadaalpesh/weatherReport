package com.alpesh.kyada.weather.report.controller;

import com.alpesh.kyada.weather.report.dto.GenericResponse;
import com.alpesh.kyada.weather.report.dto.GenericResponseStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import java.net.URL;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Alpesh
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Disabled("We can enable it based on demand")
public class WeatherReportControllerTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/weather/report/gandhinagar");
    }

    @Test
    public void weatherReportByLocation() {
        System.out.println("weatherReportByLocation");
        ResponseEntity<GenericResponse> response = template.getForEntity(base.toString(),
                GenericResponse.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        GenericResponse genericResponse = response.getBody();
        Assertions.assertNotNull(genericResponse);
        Assertions.assertEquals(GenericResponseStatus.SUCCESS, genericResponse.getStatus());

        Map weatherDetailsMap = (Map) genericResponse.getData();
        // This should be based on currunt value of weather
        Assertions.assertEquals("gandhinagar", weatherDetailsMap.get("location"));
        Assertions.assertEquals(/*"Smoke"*/"This is dummy report", weatherDetailsMap.get("weather"));
    }

}
