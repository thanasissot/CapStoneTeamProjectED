package com.eurodyn.model.people;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(updatable = false)
  private Long id;

  @Column(length = 1024, nullable = false)
  private String name;

  @Enumerated(EnumType.STRING)
  private ProfessionType profession;

  @Column(precision = 10, scale = 2, nullable = false)
  private BigDecimal salary;

  @Enumerated(EnumType.STRING)
  private SalaryType type;

  public enum SalaryType {
    PER_EPISODE,
    PER_FULL_PROJECT
  }
  public enum ProfessionType {
    ACTOR,
    DIRECTOR,
    PRODUCER,
    CREWMEMBER
  }

}
