package com.fernandoboluda.weatherapi.adapters.secondary.repository.dto;

import lombok.Data;

@Data
public class WeatherDto {

  private String id;
  private String main;
  private String description;
  private String icon;
}
