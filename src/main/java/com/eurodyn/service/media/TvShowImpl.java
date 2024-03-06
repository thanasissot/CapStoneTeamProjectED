package com.eurodyn.service.media;

import com.eurodyn.exception.MediaException;
import com.eurodyn.model.media.Movie;
import com.eurodyn.model.media.TvShow;
import com.eurodyn.model.people.Actor;
import com.eurodyn.model.people.Producer;
import com.eurodyn.repository.TvShowRepository;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TvShowImpl implements TvShowService{
    private TvShowRepository tvShowRepository;
    @Override
    public TvShow create(TvShow model) {
        tvShowRepository.save(model);
        return model;
    }

    @Override
    public List<TvShow> read() {
        return null;
    }

    @Override
    public TvShow read(Long modelId) {
        return null;
    }

    @Override
    public TvShow update(Long modelId, TvShow newModel) {
        TvShow currentTvShow = read(modelId);
        if (currentTvShow == null) {
            return null;
        }
        newModel.setId(modelId); // risky, because newRoom might be used somewhere else
        return tvShowRepository.save(newModel);
    }

    @Override
    public TvShow delete(Long modelId) {
        TvShow tvShow = read(modelId);
        if (tvShow != null) {
            tvShowRepository.delete(tvShow); // throws RuntimeException!!!
        }
        return tvShow;
    }

    @Override
    public BigDecimal findCost(Long id) throws MediaException {
        TvShow tvShow = read(id);
        BigDecimal cost = BigDecimal.ZERO;

        if (tvShow != null) {
            for (Actor actor : tvShow.getActors()) {
                cost = cost.add(
                    actor.getSalary().multiply(BigDecimal.valueOf(tvShow.getNumberOfEpisodes())));
            }
            for (Producer producer : tvShow.getProducers()) {
                cost = cost.add((BigDecimal.valueOf(140000)));
            }
        } else {
            throw new MediaException("This TV Show does not exist");
        }
        return cost;
    }
}
