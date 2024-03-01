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
public class Movie extends Media{

  @ManyToOne
  private Director director;

  @ManyToMany(mappedBy = "movies")
  private List<Actor> actors;

  @ManyToMany(mappedBy = "movies")
  private List<Producer> producers;

  @ManyToMany(mappedBy = "movies")
  private List<CrewMember> crewMembers;

  @Column(precision = 10, scale = 2, nullable = false)
  private BigDecimal productionBudget;

  @Column(nullable = false)
  private Integer yearOfRelease;
}
