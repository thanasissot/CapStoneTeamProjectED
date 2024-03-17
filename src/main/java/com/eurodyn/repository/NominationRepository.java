package com.eurodyn.repository;

import com.eurodyn.model.Nomination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NominationRepository extends JpaRepository<Nomination, Long> {
//    List<Nomination> findAllByNominationYear(Integer nominationYear);
//
//    List<Nomination> findAllByNominationResult(Nomination.NominationType nominationType);
//
//    List<Nomination> findByNominationYearBetween(Integer fromYear, Integer toYear);
}
