package com.qualco.assessment.nations_service.controller;

import com.qualco.assessment.nations_service.entity.dto.CountryStatsDTO;
import com.qualco.assessment.nations_service.service.CountryStatsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/country-stats")
@AllArgsConstructor
public class CountryStatsController {

    private CountryStatsService countryStatsService;

    @GetMapping
    public Page<CountryStatsDTO> getCountryStats(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size,
                                                 @RequestParam(defaultValue = "year") String sorting,
                                                 @RequestParam(defaultValue = "asc") String order) {
        return countryStatsService.findAll(PageRequest.of(page, size, order.equals("desc") ? Sort.by(sorting).descending() : Sort.by(sorting).ascending()));
    }
}
