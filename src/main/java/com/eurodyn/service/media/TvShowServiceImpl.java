package com.eurodyn.service.media;

import com.eurodyn.model.media.Media;
import com.eurodyn.model.media.TvShow;
import com.eurodyn.repository.TvShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class TvShowServiceImpl implements TvShowService, FindCost {
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
    public BigDecimal findCost(Media media) {
        return FindCost.super.findCost(media);
    }
}
