package com.qualco.assessment.nations_service.repository;

import com.qualco.assessment.nations_service.entity.CountryStat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryStatsRepository extends CrudRepository<CountryStat, Integer> {

    Page<CountryStat> findAll(Pageable pageable);

}
