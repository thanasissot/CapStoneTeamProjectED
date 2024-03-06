package com.eurodyn.service.media;

import com.eurodyn.dto.media.MovieDTO;
import com.eurodyn.model.media.Movie;
import com.eurodyn.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    @Override
    public Movie create(Movie model) {
        movieRepository.save(model);
        return model;
    }

    @Override
    public List<Movie> read(){
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

    }
