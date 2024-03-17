package com.eurodyn.service;

import com.eurodyn.exception.NominationException;
import com.eurodyn.model.Nomination;
import com.eurodyn.model.people.Actor;
import java.util.List;

public interface NominationService extends GenericService<Nomination, Long> {

	List<Nomination> getAllNominationsByMovieYearOfReleaseBetween(Integer fromYear, Integer toYear) throws NominationException;

}
