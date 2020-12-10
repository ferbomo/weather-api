package com.fernandoboluda.weatherapi.converters;

import com.fernandoboluda.weatherapi.adapters.primary.rest.model.WeatherResponse;
import com.fernandoboluda.weatherapi.domain.entities.Weather;

public class WeatherToWeatherResponseConverter {

  /**
   * Converts a Weather instance to a WeatherResponse.
   *
   * @param weather A Weather input.
   * @return A WeatherResponse instance.
   */
  public WeatherResponse convert(Weather weather) {
    return WeatherResponse.builder()
        .description(weather.getDescription())
        .temperature(String.valueOf(weather.getTemperature()))
        .windSpeed(String.valueOf(weather.getWindSpeed()))
        .build();
  }

}
