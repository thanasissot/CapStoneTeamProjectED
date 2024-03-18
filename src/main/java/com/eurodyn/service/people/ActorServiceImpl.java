package com.eurodyn.service.people;

import com.eurodyn.dto.people.ActorFullDto;
import com.eurodyn.mapper.ActorFullMapper;
import com.eurodyn.model.Nomination;
import com.eurodyn.model.NominationWon;
import com.eurodyn.model.UserRating;
import com.eurodyn.model.people.Actor;
import com.eurodyn.repository.ActorRepository;
import com.eurodyn.repository.NominationRepository;
import com.eurodyn.repository.NominationWonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log4j2
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;
	private final NominationWonRepository nominationWonRepository;
	private final NominationRepository nominationRepository;
	private final ActorFullMapper actorFullMapper;


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

	@Override
	public Map<Integer, Actor> getBestActorsByYearRangeAndBestRating(Integer fromYear, Integer toYear) {
		// get all nominations by year range
		List<Nomination> nominations = nominationRepository.findAllByYear(fromYear, toYear);
		// structure by year (bet actor each year based on the best rating is the goal)
		Map<Integer, List<Nomination>> mapYearNominations = nominations.stream()
				.collect(Collectors.groupingBy(
					nomination -> nomination.getMovie().getYearOfRelease()
				));

		Map<Integer, Actor> actorMap = new HashMap<>();
		for (Map.Entry<Integer, List<Nomination>> entry : mapYearNominations.entrySet()) {
			List<Nomination> nominationList = entry.getValue();
			Nomination withBestRating = findNominationWithHighestAverageRating(nominationList);
			actorMap.put(entry.getKey(), withBestRating.getActor());
		}

		return actorMap;
	}

	@Override
	public List<ActorFullDto> readActorsDto() {
		List<Actor> actors = actorRepository.findAll();
		return actors.stream().map(actorFullMapper::entityToDto).toList();
	}

	private Nomination findNominationWithHighestAverageRating(List<Nomination> nominations) {
		// Find the nomination with the highest average rating
		Optional<Nomination> highestAverageNomination = nominations.stream()
				.max(Comparator.comparingDouble(this::calculateAverageRating));

		return highestAverageNomination.orElse(null);
	}

	private double calculateAverageRating(Nomination nomination) {
		// Calculate the average rating for a nomination
		OptionalDouble averageRating = nomination.getUserRatings().stream()
				.mapToDouble(UserRating::getRating)
				.average();

		return averageRating.orElse(0.0);
	}

}
