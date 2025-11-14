package com.qualco.assessment.nations_service.repository;

import com.qualco.assessment.nations_service.entity.Continent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends CrudRepository<Continent, Integer> {
}
