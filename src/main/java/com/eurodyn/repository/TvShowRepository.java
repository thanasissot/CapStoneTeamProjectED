package com.eurodyn.repository;

import com.eurodyn.model.media.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow,Long> {
}
