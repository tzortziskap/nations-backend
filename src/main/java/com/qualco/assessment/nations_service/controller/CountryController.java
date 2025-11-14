package com.qualco.assessment.nations_service.controller;

import com.qualco.assessment.nations_service.entity.dto.CountryDTO;
import com.qualco.assessment.nations_service.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/country")
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping
    public Page<CountryDTO> getCountries(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size,
                                         @RequestParam(defaultValue = "name") String sorting,
                                         @RequestParam(defaultValue = "asc")  String order) {
        return countryService.findAll(PageRequest.of(page, size, order.equals("desc") ? Sort.by(sorting).descending() :  Sort.by(sorting).ascending()));
    }
}
