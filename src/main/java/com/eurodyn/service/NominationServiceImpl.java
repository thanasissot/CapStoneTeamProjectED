package com.eurodyn.service;

import com.eurodyn.exception.NominationException;
import com.eurodyn.model.Nomination;
import com.eurodyn.model.media.Movie;
import com.eurodyn.repository.NominationRepository;
import com.eurodyn.service.media.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class NominationServiceImpl implements NominationService {

	private final NominationRepository nominationRepository;
	private final MovieService movieService;
//	private final UserRatingRepository userRatingRepository;
//	private final NominationMapper nominationMapper;

	// create and update should verify that
	// actor nominated is an actor that played in the movie
	@Override
	public Nomination create(Nomination nomination) {
		Movie movie = nomination.getMovie();
		Movie movieFromDB = movieService.read(movie.getId());
		if (movieFromDB == null) {
			throw new NominationException("Movie does not exist.");
		} else {
			boolean actorInMovie = movieFromDB.getActors().stream().anyMatch(
					actor -> Objects.equals(actor.getId(), nomination.getActor().getId())
			);

			if (!actorInMovie) {
				throw new NominationException("Actor does not play in Movie provided.");
			}
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

//	@Override
//	public List<Nomination> getAllNominationsByMovieYearOfReleaseBetween(Integer fromYear, Integer toYear) throws NominationException {
////		List<Nomination> byYearRange = nominationRepository.findAllByYear(fromYear, toYear);
////		byYearRange.forEach(nomination -> {
////			List<UserRating> userRatings = userRatingRepository.findAllByNominationId(nomination.getId());
////			nomination.setUserRatings(userRatings);
////		});
////		return byYearRange;
//		return null;
//	}

//	public List<NominationDto> readNominationsDto() {
////		List<Nomination> nominations = nominationRepository.findAll();
////		return nominations.stream().map(nominationMapper::entityToDto).toList();
//		return null;
//
//	}

}
