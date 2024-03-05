package com.eurodyn.model.media;

import com.eurodyn.model.people.Actor;
import com.eurodyn.model.people.CrewMember;
import com.eurodyn.model.people.Director;
import com.eurodyn.model.people.Producer;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
public class Movie extends Media{

  @ManyToOne
  private Director director;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "movie_actors",
          joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
  private List<Actor> actors;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "movie_producers",
          joinColumns = @JoinColumn(name = "producer_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
  private List<Producer> producers;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "movie_crewMember",
          joinColumns = @JoinColumn(name = "crewMember_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
  private List<CrewMember> crewMembers;

  @Column(precision = 10, scale = 2, nullable = false)
  private BigDecimal productionBudget;

  @Column(nullable = false)
  private Integer yearOfRelease;
}
