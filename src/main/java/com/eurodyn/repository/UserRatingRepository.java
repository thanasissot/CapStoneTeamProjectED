package com.eurodyn.repository;

import com.eurodyn.model.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRatingRepository extends JpaRepository<UserRating, Long> {
}
