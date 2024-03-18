package com.eurodyn.mapper;

import com.eurodyn.dto.NominationForActorDto;
import com.eurodyn.model.Nomination;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GenreMapper.class, MovieMapper.class, UserRatingMapper.class})
public interface NominationForActorMapper {
	Nomination dtoToEntity(NominationForActorDto dto);

	NominationForActorDto entityToDto(Nomination entity);

}
