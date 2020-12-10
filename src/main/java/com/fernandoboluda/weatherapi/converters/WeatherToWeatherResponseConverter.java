package com.fernandoboluda.weatherapi.converters;

import com.fernandoboluda.weatherapi.adapters.primary.rest.model.WeatherResponse;
import com.fernandoboluda.weatherapi.domain.entities.Weather;

public class WeatherToWeatherResponseConverter {

  public WeatherResponse convert(Weather weather) {
    return WeatherResponse.builder()
        .description(weather.getDescription())
        .temperature(String.valueOf(weather.getTemperature()))
        .windSpeed(String.valueOf(weather.getWindSpeed()))
        .build();
  }

}
