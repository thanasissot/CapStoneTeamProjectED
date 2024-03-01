package com.eurodyn.model.people;

import com.eurodyn.model.media.Movie;
import com.eurodyn.model.media.TvShow;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
public class Producer extends Person {

  @ManyToMany(mappedBy = "producers")
  private List<Movie> movies;

  @ManyToMany(mappedBy = "producers")
  private List<TvShow> tvShows;
}
