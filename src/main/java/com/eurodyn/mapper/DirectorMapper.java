package com.eurodyn.mapper;

import com.eurodyn.dto.people.DirectorDto;
import com.eurodyn.model.people.Director;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
	Director dtoToEntity(DirectorDto dto);

	DirectorDto entityToDto(Director entity);
}
