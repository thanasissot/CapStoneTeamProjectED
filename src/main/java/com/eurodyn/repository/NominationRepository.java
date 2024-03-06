package com.eurodyn.repository;

import com.eurodyn.model.Nomination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NominationRepository extends JpaRepository<Nomination, Long> {
    List<Nomination> findAllByNominationYearAndGenre(Integer nominationYear, String genre);
}
