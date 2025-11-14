package com.qualco.assessment.nations_service.service.impl;

import com.qualco.assessment.nations_service.entity.Region;
import com.qualco.assessment.nations_service.repository.RegionRepository;
import com.qualco.assessment.nations_service.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RegionServiceImpl implements RegionService {

    private RegionRepository regionRepository;

    @Override
    public List<String> findAll() {
        return regionRepository.findAll(Sort.by("name").ascending()).stream().map(Region::getName).collect(Collectors.toList());
    }
}
