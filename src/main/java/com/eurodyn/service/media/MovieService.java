package com.eurodyn.service.media;

import com.eurodyn.dto.media.MovieDto;
import com.eurodyn.exception.MediaException;
import com.eurodyn.model.media.Media;
import com.eurodyn.model.media.Movie;
import com.eurodyn.service.GenericService;

import java.math.BigDecimal;
import java.util.List;

public interface MovieService extends GenericService<Movie, Long> {
  BigDecimal findCost(Media media);
  List<Movie> getMoviesWithCertainNominations(Integer nominatedActors) throws MediaException;

//	List<MovieDto> readMoviesDto();
}
