package com.eurodyn.service.people;

import com.eurodyn.model.people.Actor;
import com.eurodyn.service.GenericService;

import java.util.List;

public interface ActorService extends GenericService<Actor, Long> {
	List<Actor> getBestActorsByYearRange(Integer fromYear, Integer toYear);

}
