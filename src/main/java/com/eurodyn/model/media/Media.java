package com.eurodyn.model.media;

import com.eurodyn.model.Genre;
import com.eurodyn.model.people.Actor;
import com.eurodyn.model.people.CrewMember;
import com.eurodyn.model.people.Director;
import com.eurodyn.model.people.Producer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_media", discriminatorType = DiscriminatorType.STRING)
public class Media {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(updatable = false)
  private Long id;

  @Column(length = 1024, nullable = false)
  private String title;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "genre_id")
  private Genre genre;

  @ManyToOne
  private Director director;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "actor",
          joinColumns = @JoinColumn(name = "media_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
  private Set<Actor> actors;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "producer",
          joinColumns = @JoinColumn(name = "media_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "producer_id", referencedColumnName = "id"))
  private Set<Producer> producers;


  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "crewmember",
          joinColumns = @JoinColumn(name = "media_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "crewMember_id", referencedColumnName = "id"))
  private Set<CrewMember> crewMembers;

}
