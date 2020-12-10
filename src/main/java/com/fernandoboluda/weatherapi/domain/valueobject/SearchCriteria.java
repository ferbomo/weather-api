package com.fernandoboluda.weatherapi.domain.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SearchCriteria {

  private String cityName;
}
