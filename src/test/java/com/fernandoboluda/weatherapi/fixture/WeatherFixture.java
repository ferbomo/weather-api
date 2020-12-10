package com.fernandoboluda.weatherapi.fixture;

import com.fernandoboluda.weatherapi.domain.entities.Weather;

public class WeatherFixture {

  public static Weather create(String description, double temperature, double windSpeed) {
    return Weather.builder()
        .description(description)
        .temperature(temperature)
        .windSpeed(windSpeed)
        .build();
  }
}
