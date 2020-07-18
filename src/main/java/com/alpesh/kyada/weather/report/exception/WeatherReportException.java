package com.alpesh.kyada.weather.report.exception;

/**
 *
 * @author Alpesh
 */
public class WeatherReportException extends RuntimeException {

    public WeatherReportException(String message) {
        super(message);
    }

    public WeatherReportException(String message, Throwable throwable) {
        super(message, throwable);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
