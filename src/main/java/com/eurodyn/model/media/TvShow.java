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
public class TvShow extends Media {

  @ManyToOne
  private Director director;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "tvshow_actors",
          joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "tvshow_id", referencedColumnName = "id"))
  private List<Actor> actors;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "tvshow_producers",
          joinColumns = @JoinColumn(name = "producer_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "tvshow_id", referencedColumnName = "id"))
  private List<Producer> producers;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "tvshow_crewMember",
          joinColumns = @JoinColumn(name = "crewMember_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "tvshow_id", referencedColumnName = "id"))
  private List<CrewMember> crewMembers;

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
