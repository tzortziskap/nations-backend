package com.qualco.assessment.nations_service.repository;

import com.qualco.assessment.nations_service.entity.CountryStat;
import com.qualco.assessment.nations_service.entity.dto.ContinentRegionCountryStatsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryStatsRepository extends CrudRepository<CountryStat, Integer> {

    @Query("SELECT cs " +
            "FROM CountryStat cs " +
            "WHERE cs.population > 0 " +
            "AND NOT EXISTS ( " +
            "SELECT 1 " +
            "FROM CountryStat cs2 " +
            "WHERE cs2.country = cs.country " +
            "AND cs2.population > 0 " +
            "AND cs2.gdp / cs2.population > cs.gdp / cs.population)")
    Page<CountryStat> findMaxGdpPerPopulationPerCountry(Pageable pageable);


    @Query("SELECT new com.qualco.assessment.nations_service.entity.dto.ContinentRegionCountryStatsDTO(cs.year, cs.population, cs.gdp, c.name, r.name, cont.name) " +
            "FROM CountryStat cs " +
            "JOIN cs.country c " +
            "JOIN c.region r " +
            "JOIN r.continent cont " +
            "WHERE (:region IS NULL OR r.name = :region) " +
            "AND (:fromYear IS NULL OR cs.year >= :fromYear) " +
            "AND (:toYear IS NULL OR cs.year <= :toYear)")
    Page<ContinentRegionCountryStatsDTO> findFiltered(
            @Param("region") String region,
            @Param("fromYear") Integer fromYear,
            @Param("toYear") Integer toYear,
            Pageable pageable
    );
}
