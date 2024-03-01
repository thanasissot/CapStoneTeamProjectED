package com.eurodyn.model.people;

import com.eurodyn.model.media.Movie;
import com.eurodyn.model.media.TvShow;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
public class CrewMember extends Person{

  @ManyToMany(mappedBy = "crewMembers")
  private List<Movie> movies;

  @ManyToMany(mappedBy = "crewMembers")
  private List<TvShow> tvShows;
}
