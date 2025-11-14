package com.qualco.assessment.nations_service.repository;

import com.qualco.assessment.nations_service.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

    Page<Country> findAll(Pageable pageable);

}
