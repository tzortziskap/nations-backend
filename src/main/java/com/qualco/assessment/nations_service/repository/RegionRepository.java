package com.qualco.assessment.nations_service.repository;

import com.qualco.assessment.nations_service.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {}
