package com.eurodyn.mapper;

import com.eurodyn.dto.people.ActorDto;
import com.eurodyn.model.people.Actor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActorMapper {
	Actor dtoToEntity(ActorDto dto);

	ActorDto entityToDto(Actor entity);
}
