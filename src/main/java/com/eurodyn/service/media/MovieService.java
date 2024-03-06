package com.eurodyn.service.media;

import com.eurodyn.exception.MediaException;
import com.eurodyn.model.media.Movie;
import com.eurodyn.model.people.Actor;
import com.eurodyn.service.GenericService;
import java.math.BigDecimal;
import java.util.List;

public interface MovieService extends GenericService<Movie, Long> {

  BigDecimal findCost(Long id) throws MediaException;

  List<Movie> getMoviesWithCertainNominations(Integer nominatedActors) throws MediaException;
}
