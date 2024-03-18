package com.eurodyn.repository;

import com.eurodyn.model.NominationWon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface NominationWonRepository extends JpaRepository<NominationWon, Long> {
	List<NominationWon> findAllByYearOfReleaseBetween(Integer year1, Integer year2);
}
