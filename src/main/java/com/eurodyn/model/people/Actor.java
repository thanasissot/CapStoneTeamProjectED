package com.eurodyn.model.people;

import com.eurodyn.model.Nomination;
import com.eurodyn.model.media.Movie;
import com.eurodyn.model.media.TvShow;
import jakarta.persistence.*;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
public class Actor extends Person {

  @ManyToMany(mappedBy = "actors")
  private List<Movie> movies;

  @ManyToMany(mappedBy = "actors")
  private List<TvShow> tvShows;

  @OneToMany(mappedBy = "actor")
  private List<Nomination> nominations;

}
