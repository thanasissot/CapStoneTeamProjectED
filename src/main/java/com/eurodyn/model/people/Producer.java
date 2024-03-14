package com.eurodyn.model.people;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DiscriminatorValue("PRODUCER")
@Entity
public class Producer extends Person {

//  @ManyToMany(mappedBy = "producers")
//  private List<Movie> movies;
//
//  @ManyToMany(mappedBy = "producers")
//  private List<TvShow> tvShows;
}
