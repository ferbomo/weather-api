package com.fernandoboluda.weatherapi.fixture;

import com.fernandoboluda.weatherapi.domain.valueobject.SearchCriteria;

public class CriteriaFixture {

  public static SearchCriteria create(String city) {
    return SearchCriteria.builder()
        .cityName(city)
        .build();
  }
}
