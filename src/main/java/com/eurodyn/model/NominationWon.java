package com.eurodyn.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"yearOfRelease", "genre_id"}))
public class NominationWon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer yearOfRelease;

    @ManyToOne
    @JoinColumn(name = "nomination_id")
    private Nomination nomination;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
