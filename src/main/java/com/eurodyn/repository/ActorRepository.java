package com.eurodyn.repository;

import com.eurodyn.model.people.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
	@Query("SELECT a FROM Actor a JOIN FETCH a.nominations WHERE a.id = :actorId")
	Actor findByIdWithNominations(@Param("actorId") Long actorId);
}
