package com.eurodyn.model.media;

import com.eurodyn.model.people.Actor;
import com.eurodyn.model.people.CrewMember;
import com.eurodyn.model.people.Director;
import com.eurodyn.model.people.Producer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

  @ManyToMany(mappedBy = "tvShows")
  private List<Actor> actors;

  @ManyToMany(mappedBy = "tvShows")
  private List<Producer> producers;

  @ManyToMany(mappedBy = "tvShows")
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
