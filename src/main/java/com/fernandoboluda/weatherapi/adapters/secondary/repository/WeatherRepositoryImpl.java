package com.fernandoboluda.weatherapi.adapters.secondary.repository;

import com.fernandoboluda.weatherapi.adapters.secondary.repository.dto.WeatherServiceResponse;
import com.fernandoboluda.weatherapi.converters.WeatherDtoToWeatherConverter;
import com.fernandoboluda.weatherapi.domain.entities.Weather;
import com.fernandoboluda.weatherapi.domain.exception.WeatherRepositoryException;
import com.fernandoboluda.weatherapi.domain.valueobject.SearchCriteria;
import com.fernandoboluda.weatherapi.ports.secondary.WeatherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@AllArgsConstructor
public class WeatherRepositoryImpl implements WeatherRepository {

  private static final String REST_URI = "http://api.openweathermap.org/data/2.5/weather?appid="
      + "c2395dafd752b24690e1cdd50b5a6972&units=metric&q=";
  private final WeatherDtoToWeatherConverter converter;
  private final RestTemplate client;

  @Override
  @Cacheable(value = "weathers")
  public Weather getWeather(SearchCriteria searchCriteria) throws WeatherRepositoryException {

    String uri = REST_URI + searchCriteria.getCityName();
    try {
      log.info("Getting weather info for {}", searchCriteria.getCityName());
      ResponseEntity<WeatherServiceResponse> response = client
          .getForEntity(uri, WeatherServiceResponse.class);
      if (response.getStatusCode() == HttpStatus.OK) {
        WeatherServiceResponse weatherServiceResponse = response.getBody();
        return converter.convert(Objects.requireNonNull(weatherServiceResponse));
      }
      log.error("Can't retrieve international model. Status code: " + response.getStatusCode());
      throw new WeatherRepositoryException(response.getStatusCode().toString());
    } catch (RestClientException ex) {
      log.error("Can't retrieve weather response: " + ex.getMessage());
      throw new WeatherRepositoryException(ex.getMessage());
    }
  }
}
