package com.alpesh.kyada.weather.report.service.model;

/**
 *
 * @author Alpesh
 */
public class WeatherDescriptionModel {

    private String id;
    private String main;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
