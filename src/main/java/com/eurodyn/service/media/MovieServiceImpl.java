package com.eurodyn.service.media;

import com.eurodyn.exception.MediaException;
import com.eurodyn.model.media.Movie;
import com.eurodyn.model.people.Actor;
import com.eurodyn.model.people.Producer;
import com.eurodyn.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

  private final MovieRepository movieRepository;

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
    return movieRepository.findById(modelId).get();
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
  public BigDecimal findCost(Long id) throws MediaException {
    Movie movie = read(id);
    BigDecimal cost = BigDecimal.ZERO;

    if (movie != null) {
      for (Actor actor : movie.getActors()) {
        cost = cost.add(actor.getSalary().multiply(BigDecimal.valueOf(20)));
      }
      for (Producer producer : movie.getProducers()) {
        cost = cost.add((BigDecimal.valueOf(140000)));
      }
    }else{
      throw new MediaException("This movie does not exist");
    }
    return cost;
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


}
