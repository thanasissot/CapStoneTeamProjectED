package com.eurodyn.repository;

import com.eurodyn.model.people.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {
}
