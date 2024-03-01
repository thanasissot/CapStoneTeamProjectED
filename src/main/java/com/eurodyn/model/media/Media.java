package com.eurodyn.model.media;

import com.eurodyn.model.people.Actor;
import com.eurodyn.model.people.CrewMember;
import com.eurodyn.model.people.Director;
import com.eurodyn.model.people.Producer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public class Media {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(updatable = false)
  private Long id;

  @Column(length = 1024, nullable = false)
  private String title;

  @ManyToOne
  private Director director;

  @ManyToMany
  private List<Actor> actors;

  @ManyToMany
  private List<Producer> producers;

  @ManyToMany
  private List<CrewMember> crewMembers;


  @Column(length = 1024, nullable = false)
  private String genre;

}
