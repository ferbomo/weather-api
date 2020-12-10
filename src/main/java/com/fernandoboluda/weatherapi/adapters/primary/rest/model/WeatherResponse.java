package com.fernandoboluda.weatherapi.adapters.primary.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class WeatherResponse {

  private final String description;
  private final String temperature;
  @JsonProperty("wind_speed")
  private final String windSpeed;
}
