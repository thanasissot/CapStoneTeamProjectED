package com.eurodyn.service.media;

import com.eurodyn.dto.media.MovieDto;
import com.eurodyn.exception.MediaException;
import com.eurodyn.mapper.MovieMapper;
import com.eurodyn.model.media.Media;
import com.eurodyn.model.media.Movie;
import com.eurodyn.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService, FindCost {

  private final MovieRepository movieRepository;
  private final MovieMapper movieMapper;

  @Override
  public Movie create(Movie model) {
    movieRepository.save(model);
    return model;
  }

  @Override
  public List<Movie> read() {
    return movieRepository.findAll();
  }

  @Override
  public Movie read(Long modelId) {
    return movieRepository.findById(modelId).orElse(null);
  }

  @Override
  public Movie update(Long id, Movie newMovie) {
    Movie currentMovie = read(id);
    if (currentMovie == null) {
      return null;
    }
    newMovie.setId(id); // risky, because newRoom might be used somewhere else
    return movieRepository.save(newMovie);
  }

  @Override
  public Movie delete(Long id) {
    Movie movie = read(id);
    if (movie != null) {
      movieRepository.delete(movie); // throws RuntimeException!!!
    }
    return movie;
  }

  @Override
  public List<Movie> getMoviesWithCertainNominations(Integer nominatedActors) throws MediaException {
    List<Movie> movies = this.movieRepository.findAll();
    List<Movie> nominatedMovies = new ArrayList<>();

    if (!movies.isEmpty()) {
      movies.forEach(movie -> {
          AtomicReference<Integer> numberOfNomination = new AtomicReference<>(0);
          movie.getActors().forEach(actor ->{
            if(!actor.getNominations().isEmpty()){
              numberOfNomination.getAndSet(numberOfNomination.get() + 1);
            }
          });
          if(numberOfNomination.get() >= nominatedActors){
            nominatedMovies.add(movie);
          }
      });
    } else {
      throw new MediaException("Nomination for these year are not exist");
    }

    return nominatedMovies;
  }

	@Override
	public List<MovieDto> readMoviesDto() {
	  	List<Movie> movieList = movieRepository.findAll();
		return movieList.stream().map(movieMapper::entityToDto).toList();
	}


	@Override
  public BigDecimal findCost(Media media) {
    return FindCost.super.findCost(media);
  }
}
