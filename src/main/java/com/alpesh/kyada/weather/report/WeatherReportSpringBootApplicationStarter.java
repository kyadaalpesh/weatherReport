package com.alpesh.kyada.weather.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the trigger point of spring boot application
 *
 * @author Alpesh
 */
@SpringBootApplication
public class WeatherReportSpringBootApplicationStarter {

    /**
     * default context path is : weather , port is : 8080, we can override it by
     * passing system properties as server.servlet.context-path=/weather,
     * server.port=8080
     *
     * @param args
     */
    public static void main(String[] args) {
        // Check is run time argument is passed
        SpringApplication.run(WeatherReportSpringBootApplicationStarter.class, args);
    }
}
