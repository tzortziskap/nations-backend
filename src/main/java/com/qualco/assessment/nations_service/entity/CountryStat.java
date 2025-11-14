package com.qualco.assessment.nations_service.entity;

import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@IdClass(CountryStat.CountryStatId.class)
@Table(name = "country_stats", schema = "nation")
public class CountryStat {
    @Id
    @Column(name = "year", nullable = false)
    private Integer year;

    @Id
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    @ToString.Exclude
    private Country country;

    @Column(name = "population")
    private Integer population;

    @Column(name = "gdp", precision = 15)
    private BigDecimal gdp;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CountryStat that = (CountryStat) o;
        return getYear() != null && getCountry() != null && Objects.equals(getYear(), that.getYear()) && Objects.equals(getCountry().getId(), that.getCountry().getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Builder
    @Data
    public static class CountryStatId implements Serializable {
        private Integer country;
        private Integer year;
    }
}