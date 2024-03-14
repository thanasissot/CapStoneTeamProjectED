package com.eurodyn.service;

import com.eurodyn.model.Genre;
import com.eurodyn.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public List<Genre> readAll() {
        return genreRepository.findAll();
    }

    public List<Genre> createAll(List<Genre> genres) {
        return genreRepository.saveAllAndFlush(genres);
    }
}
