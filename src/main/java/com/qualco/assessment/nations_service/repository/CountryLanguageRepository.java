package com.qualco.assessment.nations_service.repository;

import com.qualco.assessment.nations_service.entity.CountryLanguage;
import com.qualco.assessment.nations_service.entity.CountryLanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageId> {

    @Query("SELECT cl.language.language FROM CountryLanguage cl WHERE cl.country.id = :countryId")
    Set<String> findLanguagesByCountryId(@Param("countryId") Integer countryId);
}

