package com.eurodyn.service.media;

import com.eurodyn.exception.MediaException;
import com.eurodyn.model.media.TvShow;
import com.eurodyn.service.GenericService;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TvShowService extends GenericService<TvShow, Long> {

  BigDecimal findCost(Long id) throws MediaException;
}
