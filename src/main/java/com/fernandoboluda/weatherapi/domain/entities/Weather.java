package com.fernandoboluda.weatherapi.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Weather {

  private final String description;
  private final double temperature;
  private final double windSpeed;
}
