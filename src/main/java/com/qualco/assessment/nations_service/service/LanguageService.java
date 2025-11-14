package com.qualco.assessment.nations_service.service;

import com.qualco.assessment.nations_service.exception.CountryNotFoundException;

import java.util.List;
import java.util.Set;

public interface LanguageService {

    Set<String> getLanguagesByCountry(int countryId) throws CountryNotFoundException;
}
