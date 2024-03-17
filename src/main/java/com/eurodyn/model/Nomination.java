package com.eurodyn.model;

import com.eurodyn.model.media.Movie;
import com.eurodyn.model.people.Actor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Nomination {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Integer nominationYear;

  @ManyToOne
  @JoinColumn(name = "movie_id")
  private Movie movie;

  @ManyToOne
  @JoinColumn(name = "actor_id")
  private Actor actor;

  @ManyToOne
  @JoinColumn(name = "genre_id")
  private Genre genre;

  @OneToMany(mappedBy = "nomination", cascade = CascadeType.ALL)
  private Set<UserRating> userRatings = new HashSet<>();

  @Enumerated(EnumType.STRING)
  private NominationType nominationResult;

  public enum NominationType {
    NOMINATED,
    WON
  }

}
