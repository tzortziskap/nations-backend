package com.qualco.assessment.nations_service.service;

import com.qualco.assessment.nations_service.entity.dto.CountryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryService {

    Page<CountryDTO> findAll(Pageable pageable);
}
