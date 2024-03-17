package com.eurodyn.service;

import com.eurodyn.model.NominationWon;
import com.eurodyn.repository.NominationWonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class NominationWonServiceImpl implements NominationWonService {
	private final NominationWonRepository nominationWonRepository;

	@Override
	public NominationWon create(NominationWon nominationWon) {
		try {
			nominationWon = nominationWonRepository.save(nominationWon);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			return null;
		}
		return nominationWon;
	}

	@Override
	public Collection<NominationWon> read() {
		return nominationWonRepository.findAll();
	}

	@Override
	public NominationWon read(Long modelId) {
		return nominationWonRepository.findById(modelId).orElse(null);
	}

	@Override
	public NominationWon update(Long modelId, NominationWon newModel) {
		return null;
	}

	@Override
	public NominationWon delete(Long modelId) {
		return null;
	}

	@Override
	public List<NominationWon> findAllByYearOfReleaseBetween(Integer fromYear, Integer toYear) {
		return nominationWonRepository.findAllByYearOfReleaseBetween(fromYear, toYear);
	}
}
