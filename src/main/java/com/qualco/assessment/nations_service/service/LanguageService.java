package com.qualco.assessment.nations_service.service;

import com.qualco.assessment.nations_service.entity.dto.LanguageDTO;
import com.qualco.assessment.nations_service.exception.CountryNotFoundException;

public interface LanguageService {

    LanguageDTO getLanguagesByCountry(int countryId) throws CountryNotFoundException;
}
