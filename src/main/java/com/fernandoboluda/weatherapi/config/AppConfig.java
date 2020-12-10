package com.fernandoboluda.weatherapi.config;

import com.fernandoboluda.weatherapi.adapters.secondary.repository.WeatherRepositoryImpl;
import com.fernandoboluda.weatherapi.converters.WeatherDtoToWeatherConverter;
import com.fernandoboluda.weatherapi.converters.WeatherToWeatherResponseConverter;
import com.fernandoboluda.weatherapi.domain.RetrieveWeatherByCityNameUseCase;
import com.fernandoboluda.weatherapi.ports.primary.WeatherApplication;
import com.fernandoboluda.weatherapi.ports.secondary.WeatherRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

  @Bean
  public WeatherDtoToWeatherConverter weatherDtoToWeatherConverter() {
    return new WeatherDtoToWeatherConverter();
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public WeatherToWeatherResponseConverter weatherToWeatherResponseConverter() {
    return new WeatherToWeatherResponseConverter();
  }

  @Bean
  public WeatherRepository weatherRepository(WeatherDtoToWeatherConverter converter,
      RestTemplate restTemplate) {
    return new WeatherRepositoryImpl(converter, restTemplate);
  }

  @Bean
  public WeatherApplication weatherApplication(WeatherRepository repository,
      WeatherToWeatherResponseConverter converter) {
    return new RetrieveWeatherByCityNameUseCase(repository, converter);
  }

}
