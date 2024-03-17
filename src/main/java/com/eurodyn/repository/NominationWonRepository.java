package com.eurodyn.repository;

import com.eurodyn.model.NominationWon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface NominationWonRepository extends JpaRepository<NominationWon, Long> {
}
