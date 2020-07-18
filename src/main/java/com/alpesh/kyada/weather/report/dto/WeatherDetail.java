package com.alpesh.kyada.weather.report.dto;

/**
 *
 * @author Alpesh
 */
public class WeatherDetail {

    private String location;
    private String weather;
    //
    //    Add other detail if we want to 

    public WeatherDetail() {
    }

    public WeatherDetail(String location, String weather) {
        this.location = location;
        this.weather = weather;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherDetail{" + "location=" + location + ", weather=" + weather + '}';
    }

}
