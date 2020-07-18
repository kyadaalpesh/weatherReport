package com.alpesh.kyada.weather.report.controller;

import com.alpesh.kyada.weather.report.controller.converter.WeatherReportModelToDtoConverter;
import com.alpesh.kyada.weather.report.dto.GenericResponse;
import com.alpesh.kyada.weather.report.dto.GenericResponseStatus;
import com.alpesh.kyada.weather.report.dto.WeatherDetail;
import com.alpesh.kyada.weather.report.exception.WeatherReportException;
import com.alpesh.kyada.weather.report.service.WeatherReportService;
import com.alpesh.kyada.weather.report.service.model.WeatherDetailModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is controller of weather report API
 *
 * @author Alpesh
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

    // Inject Service 
    @Autowired
    private WeatherReportService weatherReportService;

    /**
     *
     * @param location
     * @return
     */
    @RequestMapping(path = "/{location}")
    public GenericResponse<WeatherDetail> weatherReportByLocation(@PathVariable(name = "location") String location) {
        try {

            if (StringUtils.isEmpty(location)) {
                throw new WeatherReportException("Please enter valid location or city.");
            }

            // DO actual call and to backend and fetch the weather of given location
            WeatherDetailModel weatherDetailByLocation = weatherReportService.getWeatherDetailByLocation(location);

            // Convert to UI based Object
            WeatherDetail weatherDetail = WeatherReportModelToDtoConverter.convertToWeatherDetail(weatherDetailByLocation);

            // TODO : did extra transalation if we want
            // return the response with fetching detail
            return new GenericResponse<>(GenericResponseStatus.SUCCESS, "Weather Report generated successfully", weatherDetail);
        } catch (WeatherReportException exception) {
            logger.error(exception.getMessage(), exception);
            return new GenericResponse<>(GenericResponseStatus.ERROR, exception.getMessage(), null);
        }
    }

    /**
     *
     * @param location
     * @return
     */
    @RequestMapping
    public GenericResponse<WeatherDetail> weatherReportByLocationRequest(@RequestParam(name = "location") String location) {
        return weatherReportByLocation(location);
    }
}
