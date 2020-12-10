package com.fernandoboluda.weatherapi.adapters.primary.rest;

import com.fernandoboluda.weatherapi.domain.valueobject.SearchCriteria;
import com.fernandoboluda.weatherapi.ports.primary.WeatherApplication;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

  private final WeatherApplication weatherApplication;

  @GetMapping
  public ResponseEntity getWeather(@RequestParam String cityName) {
    if (cityName == null || cityName.isEmpty()) {
      return ResponseEntity
          .status(HttpStatus.BAD_REQUEST)
          .body("City name is mandatory");
    }
    return ResponseEntity
        .ok(weatherApplication.getWeatherByCityName(createSearchCriteria(cityName)));
  }

  private SearchCriteria createSearchCriteria(String city) {
    return SearchCriteria.builder()
        .cityName(city)
        .build();
  }

}
