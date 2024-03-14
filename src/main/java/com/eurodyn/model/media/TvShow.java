package com.eurodyn.model.media;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@DiscriminatorValue("TVSHOW")
@Entity
public class TvShow extends Media {

  @Column(nullable = false)
  private BigDecimal minBudget;

  @Column(nullable = false)
  private BigDecimal maxBudget;

  @Column(nullable = false)
  private Integer startingYear;

  @Column(nullable = false)
  private Integer endingYear;

  @Column(nullable = false)
  private Integer numberOfEpisodes;

}
