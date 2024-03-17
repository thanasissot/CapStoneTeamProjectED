package com.eurodyn.model;

import com.eurodyn.model.media.Movie;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    GenreName name;

    @OneToMany(mappedBy = "genre")
    private Set<Movie> movies;

    public enum GenreName {
        HORROR,
        ACTION,
        COMEDY,
        DRAMA
    }

}
