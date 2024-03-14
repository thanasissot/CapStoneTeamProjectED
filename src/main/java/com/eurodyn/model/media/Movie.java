package com.eurodyn.model.media;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@DiscriminatorValue("MOVIE")
@Entity
public class Movie extends Media{

  @Column(nullable = false)
  private BigDecimal productionBudget;

  @Column(nullable = false)
  private Integer yearOfRelease;
}
