package com.fernandoboluda.weatherapi.adapters.secondary.repository.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherServiceResponse {

  private Coordinates coord;
  @JsonProperty("weather")
  private List<Weather> weatherList;
  private String base;
  private Main main;
  private int visibility;
  private Wind wind;
  private Clouds clouds;
  private long dt;
  private Sys sys;
  private int timezone;
  private int id;
  private String name;
  private int cod;
}
