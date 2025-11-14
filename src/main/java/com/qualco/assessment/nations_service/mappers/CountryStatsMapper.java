package com.qualco.assessment.nations_service.mappers;

import com.qualco.assessment.nations_service.entity.CountryStat;
import com.qualco.assessment.nations_service.entity.dto.CountryStatsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CountryStatsMapper {

    @Mapping(source = "country.name", target = "name")
    @Mapping(source = "country.countryCode3", target = "countryCode3")
    CountryStatsDTO countryToCountryDTO(CountryStat countryStat);
}
