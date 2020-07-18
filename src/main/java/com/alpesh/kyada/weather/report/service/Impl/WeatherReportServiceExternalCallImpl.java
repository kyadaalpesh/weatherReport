package com.alpesh.kyada.weather.report.service.Impl;

import com.alpesh.kyada.weather.report.exception.WeatherReportException;
import com.alpesh.kyada.weather.report.service.WeatherReportService;
import com.alpesh.kyada.weather.report.service.model.WeatherDetailModel;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * This is one of Implementation of WeatherReportService which call external API
 * to fetch actual data. We can implement it to some dummy data , Database calls
 * or any other data provider as well
 *
 * @author Alpesh
 */
@Service
public class WeatherReportServiceExternalCallImpl implements WeatherReportService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherReportServiceExternalCallImpl.class);

    // We can Use Pure HTTP CONNECTION to tech data from external API 
    // We already in Spring boot application so that we can access the REstTemplae
    private final RestTemplate restTemplate = new RestTemplate();

    @Value(value = "${external.api.url}")
    private String externalApiUrl;

    /**
     * This method will return the weather details of given location or city
     *
     * @param locationOrCity
     * @return
     * @throws WeatherReportException
     */
    @Override
    public WeatherDetailModel getWeatherDetailByLocation(String locationOrCity) throws WeatherReportException {

        URL url = null;
        try {
            String apiUrl = externalApiUrl + locationOrCity;
            logger.debug("****** Calling " + apiUrl);
            url = new URL(apiUrl);
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new WeatherReportException("Please Configured the valid external URL in properties file", exception);
        }
        try {
            ResponseEntity<WeatherDetailModel> response = restTemplate.getForEntity(url.toString(),
                    WeatherDetailModel.class);

            WeatherDetailModel weatherDetailModel = response.getBody();
            if (weatherDetailModel == null) {
                throw new WeatherReportException("Connection problem with external API url. Could you please wait for sometime.");
            }
            if (HttpStatus.OK.equals(response.getStatusCode())) {
                return weatherDetailModel;
            } else if (HttpStatus.NOT_FOUND.equals(response.getStatusCode())) {
                throw new WeatherReportException("Please enter valid location or city.");
            } else if (HttpStatus.UNAUTHORIZED.equals(response.getStatusCode())) {
                throw new WeatherReportException("Please use valid API ID in external API Url.");
            } else {
                throw new WeatherReportException(weatherDetailModel.getMessage());
            }
        } catch (HttpClientErrorException.NotFound exception) {
            logger.error(exception.getMessage(), exception);
            throw new WeatherReportException("Please enter valid location or city.");
        } catch (HttpClientErrorException.Unauthorized exception) {
            logger.error(exception.getMessage(), exception);
            throw new WeatherReportException("Please use valid API ID in external API Url.");
        }

    }
}
