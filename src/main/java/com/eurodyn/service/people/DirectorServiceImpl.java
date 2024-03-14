package com.eurodyn.service.people;

import com.eurodyn.model.people.Director;
import com.eurodyn.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService{

    private final DirectorRepository directorRepository;
    @Override
    public Director create(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public List<Director> read() {
        return directorRepository.findAll();
    }

    @Override
    public Director read(Long directorId) {
      Optional<Director> director = directorRepository.findById(directorId);
        return director.orElse(null);
    }

    @Override
    public Director update(Long directorId, Director newDirector) {
        Optional<Director> director = directorRepository.findById(directorId);
        if (director.isEmpty()) {
            return null;
        }
        Director currentDirector = director.get();
        newDirector.setId(currentDirector.getId());
        return directorRepository.save(newDirector);
    }

    @Override
    public Director delete(Long directorId) {
        Optional<Director> director = directorRepository.findById(directorId);
        if (director.isEmpty()) {
            return null;
        }
        directorRepository.delete(director.get());
        return director.get();
    }
}
