package com.eurodyn.service;

import com.eurodyn.exception.NominationException;
import com.eurodyn.model.Nomination;
import com.eurodyn.model.people.Actor;
import com.eurodyn.repository.NominationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class NominationServiceImpl implements NominationService {
    private final NominationRepository nominationRepository;

    // create and update should verify 2 things
    // 1. there is no same actor for same year and genre of nomination
    // 2. there is only 1 WON result for same year and genre
    // 3. we are making th year/genre/actor but only logically not defined in schema

    @Override
    public Nomination create(Nomination nomination) {
        List<Nomination> nominations = nominationRepository.findAllByNominationYearAndGenre(nomination.getNominationYear(), nomination.getGenre());

        boolean nominationExists = nominations.stream().anyMatch(nomination1 -> Objects.equals(nomination1.getActor().getId(), nomination.getActor().getId()));
        if (nominationExists) {
            // throw exception cannot create
            throw new NominationException("Year and Genre combination already exists - cannot create/update Nomination.");
        }

        if (nomination.getNominationResult().equals(Nomination.NominationType.WON)
            && nominations.stream().anyMatch(nomination2 -> nomination2.getNominationResult().equals(Nomination.NominationType.WON))
        ) {
            // throw exception cannot create WON already exists
            throw new NominationException("Year and Genre and WON combination already exists - cannot create/update Nomination.");
        }

        return nominationRepository.save(nomination);
    }

    @Override
    public List<Nomination> read() {
        return nominationRepository.findAll();
    }

    @Override
    public Nomination read(Long nominationId) {
        return nominationRepository.findById(nominationId).orElse(null);
    }

    @Override
    public Nomination update(Long nominationId, Nomination newNomination) {
        newNomination.setId(nominationId);
        return create(newNomination);
    }

    @Override
    public Nomination delete(Long nominationId) {
        Nomination nomination = read(nominationId);
        if (nomination == null) {
            return null;
        }
        nominationRepository.delete(nomination);
        return nomination;
    }

}
