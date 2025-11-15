package com.qualco.assessment.nations_service.service.impl;

import com.qualco.assessment.nations_service.entity.Country;
import com.qualco.assessment.nations_service.entity.dto.LanguageDTO;
import com.qualco.assessment.nations_service.exception.CountryNotFoundException;
import com.qualco.assessment.nations_service.repository.CountryLanguageRepository;
import com.qualco.assessment.nations_service.repository.CountryRepository;
import com.qualco.assessment.nations_service.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private CountryRepository countryRepository;
    private CountryLanguageRepository countryLanguageRepository;

    @Override
    public LanguageDTO getLanguagesByCountry(int countryId) throws CountryNotFoundException {
        final Country country = countryRepository.findById(countryId).orElseThrow(() -> new CountryNotFoundException("There is not such country id in the database!"));
        return new LanguageDTO(country.getName(), countryLanguageRepository.findLanguagesByCountryId(country.getId()));
    }
}
