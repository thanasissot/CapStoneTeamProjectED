package com.eurodyn.model.people;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DiscriminatorValue("DIRECTOR")
@Entity
public class Director extends Person {
//
//  @OneToMany(mappedBy = "director")
//  private List<Movie> movies;
//
//  @OneToMany(mappedBy = "director")
//  private List<TvShow> tvShows;
}
