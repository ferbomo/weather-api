package com.fernandoboluda.weatherapi.ports.secondary;


import com.fernandoboluda.weatherapi.domain.entities.Weather;
import com.fernandoboluda.weatherapi.domain.valueobject.SearchCriteria;

public interface WeatherRepository {

  Weather getWeather(SearchCriteria searchCriteria);
}
