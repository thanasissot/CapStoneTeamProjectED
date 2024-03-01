package com.eurodyn.model;

import com.eurodyn.model.people.Actor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
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
  private Integer year;

  @ManyToMany(mappedBy = "nominations")
  private List<Actor> actors;

  @Enumerated(EnumType.STRING)
  private NominationType nominationResult;

  public enum NominationType {
    NOMINATED,
    WON
  }

}
