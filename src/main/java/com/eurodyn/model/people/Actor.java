package com.eurodyn.model.people;

import com.eurodyn.model.Nomination;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@DiscriminatorValue("ACTOR")
@Entity
public class Actor extends Person {

  @OneToMany(mappedBy = "actor", fetch = FetchType.EAGER)
  private List<Nomination> nominations;

  @Override
  public int hashCode() {
    // Hash calculation based on unique properties of Child2
    // Incorporate the parent class hash code to maintain consistency
    return Objects.hash(super.hashCode(), getName(), getId());
  }

}
