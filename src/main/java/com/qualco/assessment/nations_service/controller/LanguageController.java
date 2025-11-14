package com.qualco.assessment.nations_service.controller;

import com.qualco.assessment.nations_service.exception.CountryNotFoundException;
import com.qualco.assessment.nations_service.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/language")
@AllArgsConstructor
public class LanguageController {

    private LanguageService languageService;

    @GetMapping("/country/{countryId}")
    public ResponseEntity<?> getLanguagesByCounty(@PathVariable int countryId) {
        try {
            return new ResponseEntity<Set<String>>(languageService.getLanguagesByCountry(countryId), HttpStatus.OK);
        } catch (CountryNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }
}
