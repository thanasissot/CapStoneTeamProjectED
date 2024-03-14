package com.eurodyn.model.people;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DiscriminatorValue("CREW_MEMBER")
@Entity
public class CrewMember extends Person{

//  @ManyToMany(mappedBy = "crewMembers")
//  private List<Movie> movies;
//
//  @ManyToMany(mappedBy = "crewMembers")
//  private List<TvShow> tvShows;
}
