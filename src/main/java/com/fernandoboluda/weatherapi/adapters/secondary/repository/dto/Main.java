package com.fernandoboluda.weatherapi.adapters.secondary.repository.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Main {

  private double temp;
  @JsonProperty("feels_like")
  private double feelsLike;
  @JsonProperty("temp_min")
  private double tempMin;
  @JsonProperty("temp_max")
  private double tempMax;
  private int pressure;
  private int humidity;
}
