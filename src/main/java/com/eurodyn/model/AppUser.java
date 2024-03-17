package com.eurodyn.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    private String fullName;

//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    List<UserRating> userRatings;


}
