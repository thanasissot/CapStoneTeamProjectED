package com.eurodyn.mapper;

import com.eurodyn.dto.media.MovieDto;
import com.eurodyn.model.media.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GenreMapper.class, ActorMapper.class, DirectorMapper.class, ProducerMapper.class, CrewMemberMapper.class})
public interface MovieMapper {
	Movie dtoToEntity(MovieDto dto);
	MovieDto entityToDto(Movie entity);

}
