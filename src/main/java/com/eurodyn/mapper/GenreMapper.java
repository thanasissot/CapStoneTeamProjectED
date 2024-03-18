package com.eurodyn.mapper;

import com.eurodyn.dto.GenreDto;
import com.eurodyn.model.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper {

	Genre dtoToEntity(GenreDto dto);
	GenreDto entityToDto(Genre entity);
}
