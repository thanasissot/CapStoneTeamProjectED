package com.eurodyn.model.media;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "TVSHOW")
public class TvShow extends Media {

  @Column(precision = 10, scale = 2, nullable = false)
  private BigDecimal minBudget;

  @Column(precision = 10, scale = 2, nullable = false)
  private BigDecimal maxBudget;

  @Column(nullable = false)
  private Integer startingYear;

  @Column(nullable = false)
  private Integer endingYear;

  @Column(nullable = false)
  private Integer numberOfEpisodes;

}
