package com.qualco.assessment.nations_service.service;

import com.qualco.assessment.nations_service.entity.dto.CountryStatsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryStatsService {

    Page<CountryStatsDTO> findAll(Pageable pageable);
}
