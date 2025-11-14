package com.qualco.assessment.nations_service.controller;

import com.qualco.assessment.nations_service.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/region")
@AllArgsConstructor
public class RegionController {

    private RegionService regionService;

    @GetMapping
    public List<String> getCountries() {
        return regionService.findAll();
    }
}
