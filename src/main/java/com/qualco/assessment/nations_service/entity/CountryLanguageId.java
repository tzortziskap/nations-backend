package com.qualco.assessment.nations_service.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class CountryLanguageId implements Serializable {
    private static final long serialVersionUID = -8971788241580686473L;
    @Column(name = "country_id", nullable = false)
    private Integer countryId;

    @Column(name = "language_id", nullable = false)
    private Integer languageId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CountryLanguageId entity = (CountryLanguageId) o;
        return Objects.equals(this.languageId, entity.languageId) &&
                Objects.equals(this.countryId, entity.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageId, countryId);
    }

}