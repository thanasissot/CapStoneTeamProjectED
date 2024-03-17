package com.eurodyn.service.media;

import com.eurodyn.model.media.Media;
import com.eurodyn.model.media.TvShow;
import com.eurodyn.service.GenericService;

import java.math.BigDecimal;

public interface TvShowService extends GenericService<TvShow, Long> {
  BigDecimal findCost(Media media);
}
