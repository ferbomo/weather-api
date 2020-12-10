package com.fernandoboluda.weatherapi.converters;

import com.fernandoboluda.weatherapi.adapters.secondary.repository.dto.WeatherServiceResponse;
import com.fernandoboluda.weatherapi.domain.entities.Weather;

public class WeatherDtoToWeatherConverter {

  /**
   * Converts a WeatherServiceResponse to a Weather instance.
   *
   * @param weatherServiceResponse The weatherServiceResponse input.
   * @return A Weather instance.
   */
  public Weather convert(WeatherServiceResponse weatherServiceResponse) {
    return Weather.builder()
        //.description(weatherServiceResponse.getWeather().get(0).get("description").asText())
        .description(weatherServiceResponse.getWeatherList().get(0).getDescription())
        .temperature(weatherServiceResponse.getMain().getTemp())
        .windSpeed(weatherServiceResponse.getWind().getSpeed())
        .build();
  }

}
