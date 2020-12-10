package com.fernandoboluda.weatherapi.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import com.fernandoboluda.weatherapi.adapters.primary.rest.model.WeatherResponse;
import com.fernandoboluda.weatherapi.converters.WeatherToWeatherResponseConverter;
import com.fernandoboluda.weatherapi.domain.entities.Weather;
import com.fernandoboluda.weatherapi.domain.exception.WeatherRepositoryException;
import com.fernandoboluda.weatherapi.domain.valueobject.SearchCriteria;
import com.fernandoboluda.weatherapi.fixture.CriteriaFixture;
import com.fernandoboluda.weatherapi.fixture.WeatherFixture;
import com.fernandoboluda.weatherapi.ports.secondary.WeatherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RetrieveWeatherByCityNameUseCaseTest {

  @Mock
  private WeatherRepository repository;
  @Spy
  private WeatherToWeatherResponseConverter converter;
  @InjectMocks
  private RetrieveWeatherByCityNameUseCase target;

  @Test
  void shouldReturnWeather() throws WeatherRepositoryException {
    SearchCriteria criteria = CriteriaFixture.create("Madrid");
    Weather weather = WeatherFixture.create("clear sky", 5.76, 0.48);
    when(repository.getWeather(criteria)).thenReturn(weather);

    WeatherResponse result = target.getWeatherByCityName(criteria);

    assertThat(result, is(notNullValue()));
    assertThat(result.getDescription(), is(weather.getDescription()));
    assertThat(result.getTemperature(), is(String.valueOf(weather.getTemperature())));
    assertThat(result.getWindSpeed(), is(String.valueOf(weather.getWindSpeed())));
  }

}