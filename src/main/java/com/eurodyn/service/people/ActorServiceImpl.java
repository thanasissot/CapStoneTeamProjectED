package com.eurodyn.service.people;

import com.eurodyn.model.NominationWon;
import com.eurodyn.model.people.Actor;
import com.eurodyn.repository.ActorRepository;
import com.eurodyn.repository.NominationWonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;
	private final NominationWonRepository nominationWonRepository;


    @Override
    public Actor create(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public List<Actor> read() {
        return actorRepository.findAll();
    }

    @Override
    public Actor read(Long actorId) {

        return actorRepository.findById(actorId).orElse(null);
    }

    @Override
    public Actor update(Long actorId, Actor newActor) {
        newActor.setId(actorId);
        return create(newActor);
    }

    @Override
    public Actor delete(Long actorId) {
        Actor actor = read(actorId);
        if (actor == null) {
            return null;
        }
        actorRepository.delete(actor);
        return actor;
    }

	@Override
	public List<Actor> getBestActorsByYearRange(Integer fromYear, Integer toYear) {
		List<NominationWon> nominationWonList = nominationWonRepository.findAllByYearOfReleaseBetween(fromYear, toYear);
		return nominationWonList.stream()
				.map(nominationWon -> nominationWon.getNomination().getActor())
				.toList();
	}

}
