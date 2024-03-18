package com.eurodyn.model;

import com.eurodyn.model.media.Movie;
import com.eurodyn.model.people.Actor;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
  private List<UserRating> userRatings;

//  @Transient
//  private NominationType nominationResult;
//
//  public enum NominationType {
//    NOMINATED,
//    WON
//  }

}
