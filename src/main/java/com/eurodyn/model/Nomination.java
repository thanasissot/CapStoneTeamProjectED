package com.eurodyn.model;

import com.eurodyn.exception.NominationException;
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
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"movie_id", "actor_id"}))
public class Nomination {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "movie_id")
  private Movie movie;

  @ManyToOne
  @JoinColumn(name = "actor_id")
  private Actor actor;

  @Transient
  private Genre genre;

  @Transient
  private Integer nominationYear;

  @OneToMany(mappedBy = "nomination", cascade = CascadeType.ALL)
  private Set<UserRating> userRatings = new HashSet<>();

//  @Transient
//  private NominationType nominationResult;
//
//  public enum NominationType {
//    NOMINATED,
//    WON
//  }

  @PostLoad
  public void setTransientFields() {
    if (movie != null) {
      genre = movie.getGenre();
      nominationYear = movie.getYearOfRelease();
    }

    throw new NominationException("error occurred while trying to access Movie field for Nomination, err=No movie exists for this Nomination.");
  }

  public Genre getGenre() {
    if (movie != null) {
      return movie.getGenre();
    }

    throw new NominationException("error occurred while trying to get Genre for Nomination, err=No movie exists for this Nomination.");
  }

  public Integer getNominationYear() {
    if (movie != null) {
      return movie.getYearOfRelease();
    }

    throw new NominationException("error occurred while trying to get Year for Nomination, err=No movie exists for this Nomination.");
  }

}
