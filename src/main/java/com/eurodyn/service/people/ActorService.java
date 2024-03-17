package com.eurodyn.service.people;

import com.eurodyn.model.people.Actor;
import com.eurodyn.service.GenericService;

import java.util.List;
import java.util.Map;

public interface ActorService extends GenericService<Actor, Long> {
	List<Actor> getBestActorsByYearRange(Integer fromYear, Integer toYear);
	Map<Integer, Actor> getBestActorsByYearRangeAndBestRating(Integer fromYear, Integer toYear);
}
