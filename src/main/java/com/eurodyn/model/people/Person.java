package com.eurodyn.model.people;

import com.eurodyn.model.media.Media;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "profession", discriminatorType = DiscriminatorType.STRING)
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(updatable = false)
  private Long id;

  @Column(length = 1024, nullable = false)
  private String name;

  @Column(precision = 10, scale = 2, nullable = false)
  private BigDecimal salary;

  @Enumerated(EnumType.STRING)
  private SalaryType type;

  @OneToMany(mappedBy = "director")
  private Set<Media> mediaDirector;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "crewMembers")
  private Set<Media> mediaCrews;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "producers")
  private Set<Media> mediaProducers;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "actors")
  private Set<Media> mediaActors;


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
