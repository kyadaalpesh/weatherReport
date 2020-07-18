package com.alpesh.kyada.weather.report.controller.converter;

import com.alpesh.kyada.weather.report.dto.WeatherDetail;
import com.alpesh.kyada.weather.report.service.model.WeatherDescriptionModel;
import com.alpesh.kyada.weather.report.service.model.WeatherDetailModel;
import java.util.List;

/**
 *
 * @author Alpesh
 */
public class WeatherReportModelToDtoConverter {

    private WeatherReportModelToDtoConverter() {
        // We do not want to create instance of this class 
        //        This is util class 
    }

    /**
     *
     * @param weatherDetailModel
     * @return
     */
    public static WeatherDetail convertToWeatherDetail(WeatherDetailModel weatherDetailModel) {
        WeatherDetail weatherDetail = new WeatherDetail();
        if (weatherDetailModel != null) {
            weatherDetail.setLocation(weatherDetailModel.getName());
            List<WeatherDescriptionModel> weatherDescriptions = weatherDetailModel.getWeather();
            if (weatherDescriptions != null && !weatherDescriptions.isEmpty()) {
                WeatherDescriptionModel descriptionModel = weatherDescriptions.get(0);
                weatherDetail.setWeather(descriptionModel.getMain());
            }
            // TODO :: Map the remaining fields
        }
        return weatherDetail;
    }

    // TODO : Add reverse converter method  if required ....
}
