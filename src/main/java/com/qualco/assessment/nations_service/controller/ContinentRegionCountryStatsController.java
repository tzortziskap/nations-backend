package com.qualco.assessment.nations_service.controller;

import com.qualco.assessment.nations_service.entity.dto.ContinentRegionCountryStatsDTO;
import com.qualco.assessment.nations_service.enums.SortFieldEnum;
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
@RequestMapping("/api/v1/continents-region-country-stats")
@AllArgsConstructor
public class ContinentRegionCountryStatsController {

    private CountryStatsService countryStatsService;

    @GetMapping
    public Page<ContinentRegionCountryStatsDTO> getCountryStats(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "year") String sorting,
            @RequestParam(defaultValue = "asc") String order,
            @RequestParam(required = false) String region,
            @RequestParam(required = false) Integer fromYear,
            @RequestParam(required = false) Integer toYear
    ) {
        sorting = SortFieldEnum.getDaoPath(ContinentRegionCountryStatsDTO.class, sorting);
        Sort sort = order.equalsIgnoreCase("desc") ?
                Sort.by(sorting).descending() :
                Sort.by(sorting).ascending();
        return countryStatsService.getContinentRegionCountryStats(region, fromYear, toYear, PageRequest.of(page, size, sort));
    }
}
