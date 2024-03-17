package com.eurodyn.repository;

import com.eurodyn.model.Nomination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NominationRepository extends JpaRepository<Nomination, Long> {

	@Query("SELECT n FROM Nomination n JOIN n.movie m WHERE m.yearOfRelease BETWEEN :yearFrom AND :yearTo")
	List<Nomination> findAllByYear(Integer yearFrom, Integer yearTo);

//
//    List<Nomination> findAllByNominationResult(Nomination.NominationType nominationType);
//
//    List<Nomination> findByNominationYearBetween(Integer fromYear, Integer toYear);
}
