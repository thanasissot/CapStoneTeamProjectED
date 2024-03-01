package com.eurodyn.model.people;

import com.eurodyn.model.media.Movie;
import com.eurodyn.model.media.TvShow;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
public class Director extends Person {

  @OneToMany(mappedBy = "director")
  private List<Movie> movies;

  @OneToMany(mappedBy = "director")
  private List<TvShow> tvShows;
}
