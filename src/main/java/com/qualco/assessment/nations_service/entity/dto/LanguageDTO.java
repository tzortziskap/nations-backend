package com.qualco.assessment.nations_service.entity.dto;

import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LanguageDTO {

    private String country;
    private Set<String> languages;
}
