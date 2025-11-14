package com.qualco.assessment.nations_service.mappers;

import com.qualco.assessment.nations_service.entity.Country;
import com.qualco.assessment.nations_service.entity.dto.CountryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryDTO countryToCountryDTO(Country country);
}
