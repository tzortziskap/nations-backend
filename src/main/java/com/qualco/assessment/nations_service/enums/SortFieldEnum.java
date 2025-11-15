package com.qualco.assessment.nations_service.enums;

import com.qualco.assessment.nations_service.entity.dto.ContinentRegionCountryStatsDTO;
import com.qualco.assessment.nations_service.entity.dto.CountryStatsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum SortFieldEnum {

    COUNTRY_STATS_CONTINENT_NAME(CountryStatsDTO.class, "name", "country.name"),
    COUNTRY_STATS_COUNTRY_CODE_3(CountryStatsDTO.class, "countryCode3", "country.countryCode3"),

    CONTINENT_REGION_COUNTRY_STATS_CONTINENT_NAME(ContinentRegionCountryStatsDTO.class, "continentName", "country.region.continent.name"),
    CONTINENT_REGION_COUNTRY_STATS_REGION_NAME(ContinentRegionCountryStatsDTO.class, "regionName", "country.region.name"),
    CONTINENT_REGION_COUNTRY_STATS_COUNTRY_NAME(ContinentRegionCountryStatsDTO.class, "countryName", "country.name");

    private final Class<?> dtoClass;
    private final String dtoField;
    private final String daoPath;

    private static final Map<String, String> LOOKUP = new HashMap<>();

    static {
        for (SortFieldEnum field : values()) {
            String key = buildKey(field.getDtoClass(), field.getDtoField());
            LOOKUP.put(key, field.getDaoPath());
        }
    }

    private static String buildKey(Class<?> clazz, String field) {
        return clazz.getName() + "#" + field;
    }

    public static String getDaoPath(Class<?> dtoClass, String dtoField) {
        String key = buildKey(dtoClass, dtoField);
        String daoPath = LOOKUP.get(key);
        if (daoPath == null) {
            return dtoField;
        }
        return daoPath;
    }
}
