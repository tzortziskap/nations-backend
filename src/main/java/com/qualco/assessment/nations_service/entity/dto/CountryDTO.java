package com.qualco.assessment.nations_service.entity.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CountryDTO {
    private Integer id;
    private String name;
    private BigDecimal area;
    private String countryCode2;
}
