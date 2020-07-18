package com.alpesh.kyada.weather.report.service;

import com.alpesh.kyada.weather.report.exception.WeatherReportException;
import com.alpesh.kyada.weather.report.service.model.WeatherDetailModel;

/**
 *
 * @author Alpesh
 */
public interface WeatherReportService {

    /**
     * This method will return the weather details of given location or city
     *
     * @param locationOrCity
     * @return
     * @throws WeatherReportException
     */
    public WeatherDetailModel getWeatherDetailByLocation(String locationOrCity) throws WeatherReportException;
}
