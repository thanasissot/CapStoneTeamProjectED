package com.eurodyn.mapper;

import com.eurodyn.dto.people.ActorFullDto;
import com.eurodyn.model.people.Actor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MovieMapper.class, NominationForActorMapper.class})
public interface ActorFullMapper {
	Actor dtoToEntity(ActorFullDto dto);

	ActorFullDto entityToDto(Actor entity);

}
