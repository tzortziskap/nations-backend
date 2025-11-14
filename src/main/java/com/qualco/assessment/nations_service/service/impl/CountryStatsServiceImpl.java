package com.qualco.assessment.nations_service.service.impl;

import com.qualco.assessment.nations_service.entity.dto.ContinentRegionCountryStatsDTO;
import com.qualco.assessment.nations_service.entity.dto.CountryStatsDTO;
import com.qualco.assessment.nations_service.mappers.CountryStatsMapper;
import com.qualco.assessment.nations_service.repository.CountryStatsRepository;
import com.qualco.assessment.nations_service.service.CountryStatsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryStatsServiceImpl implements CountryStatsService {

    private CountryStatsRepository countryStatsRepository;
    private CountryStatsMapper countryStatsMapper;

    @Override
    public Page<CountryStatsDTO> findAll(Pageable pageable) {
        return countryStatsRepository.findAll(pageable).map(countryStatsMapper::countryToCountryDTO);
    }

    @Override
    public Page<ContinentRegionCountryStatsDTO> getContinentRegionCountryStats(String region, Integer fromYear, Integer toYear, Pageable pageable) {
        return countryStatsRepository.findFiltered(region, fromYear, toYear, pageable);
    }
}
