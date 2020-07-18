package com.alpesh.kyada.weather.report.service.model;

import java.util.List;

/**
 *
 * @author Alpesh
 */
public class WeatherDetailModel {

    private String id;
    private String cod;
    private String name;
    private List<WeatherDescriptionModel> weather;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WeatherDescriptionModel> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDescriptionModel> weather) {
        this.weather = weather;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
