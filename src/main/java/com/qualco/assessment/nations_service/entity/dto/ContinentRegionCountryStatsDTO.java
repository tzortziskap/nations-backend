package com.qualco.assessment.nations_service.entity.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ContinentRegionCountryStatsDTO {
    private Integer year;
    private Integer population;
    private BigDecimal gdp;
    private String countryName;
    private String regionName;
    private String continentName;
}
