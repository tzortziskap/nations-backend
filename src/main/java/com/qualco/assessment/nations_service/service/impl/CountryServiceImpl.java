package com.qualco.assessment.nations_service.service.impl;

import com.qualco.assessment.nations_service.entity.dto.CountryDTO;
import com.qualco.assessment.nations_service.mappers.CountryMapper;
import com.qualco.assessment.nations_service.repository.CountryRepository;
import com.qualco.assessment.nations_service.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;
    private CountryMapper countryMapper;

    @Override
    public Page<CountryDTO> findAll(Pageable pageable) {
        return countryRepository.findAll(pageable).map(countryMapper::countryToCountryDTO);
    }
}
