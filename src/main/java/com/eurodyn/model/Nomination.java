package com.eurodyn.model;

import com.eurodyn.model.people.Actor;
import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Nomination {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Integer nominationYear;

  private String genre;

  @ManyToOne
  private Actor actor;

  @Enumerated(EnumType.STRING)
  private NominationType nominationResult;

  public enum NominationType {
    NOMINATED,
    WON
  }

}
