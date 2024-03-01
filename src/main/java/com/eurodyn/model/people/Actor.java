package com.eurodyn.model.people;

import com.eurodyn.model.Nomination;
import com.eurodyn.model.media.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ACTOR")
public class Actor extends Person{


  @OneToMany(mappedBy = "actor")
  private List<Nomination> nominations;
}
