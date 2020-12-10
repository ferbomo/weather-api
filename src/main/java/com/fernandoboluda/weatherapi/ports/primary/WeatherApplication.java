package com.fernandoboluda.weatherapi.ports.primary;


import com.fernandoboluda.weatherapi.adapters.primary.rest.model.WeatherResponse;
import com.fernandoboluda.weatherapi.domain.valueobject.SearchCriteria;

public interface WeatherApplication {

  WeatherResponse getWeatherByCityName(SearchCriteria searchCriteria);
}
