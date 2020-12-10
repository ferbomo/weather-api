package com.fernandoboluda.weatherapi.domain;

import com.fernandoboluda.weatherapi.adapters.primary.rest.model.WeatherResponse;
import com.fernandoboluda.weatherapi.converters.WeatherToWeatherResponseConverter;
import com.fernandoboluda.weatherapi.domain.entities.Weather;
import com.fernandoboluda.weatherapi.domain.exception.WeatherRepositoryException;
import com.fernandoboluda.weatherapi.domain.valueobject.SearchCriteria;
import com.fernandoboluda.weatherapi.ports.primary.WeatherApplication;
import com.fernandoboluda.weatherapi.ports.secondary.WeatherRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RetrieveWeatherByCityNameUseCase implements WeatherApplication {

  private final WeatherRepository repository;
  private final WeatherToWeatherResponseConverter converter;

  @Override
  public WeatherResponse getWeatherByCityName(SearchCriteria searchCriteria)
      throws WeatherRepositoryException {
    Weather weather = repository.getWeather(searchCriteria);
    return converter.convert(weather);
  }
}
