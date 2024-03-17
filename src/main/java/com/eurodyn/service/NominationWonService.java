package com.eurodyn.service;

import com.eurodyn.model.NominationWon;

import java.util.List;

public interface NominationWonService  extends GenericService<NominationWon, Long> {
	List<NominationWon> findAllByYearOfReleaseBetween(Integer fromYear, Integer toYear);
}
