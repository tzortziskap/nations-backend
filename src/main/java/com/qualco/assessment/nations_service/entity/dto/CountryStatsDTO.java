package com.qualco.assessment.nations_service.entity.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CountryStatsDTO {

    private Integer year;
    private String name;
    private String countryCode3;
    private Integer population;
    private BigDecimal gdp;

}
