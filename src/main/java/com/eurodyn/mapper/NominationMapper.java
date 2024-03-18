package com.eurodyn.mapper;

import com.eurodyn.dto.GenreDto;
import com.eurodyn.dto.NominationDto;
import com.eurodyn.dto.media.MovieDto;
import com.eurodyn.model.Nomination;
import com.eurodyn.model.media.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {MovieMapper.class, ActorMapper.class, UserRatingMapper.class})
public interface NominationMapper {
	NominationMapper INSTANCE = Mappers.getMapper(NominationMapper.class);
	GenreMapper INSTANCE_2 = Mappers.getMapper(GenreMapper.class);
	UserRatingMapper INSTANCE_3 = Mappers.getMapper(UserRatingMapper.class);
	ActorMapper INSTANCE_4 = Mappers.getMapper(ActorMapper.class);

	Nomination dtoToEntity(NominationDto dto);

	@Mapping(source = "movie", target = "genre", qualifiedByName = "setGenreDto")
	@Mapping(source = "movie", target = "nominationYear", qualifiedByName = "setNominationYear")
	NominationDto entityToDto(Nomination entity);

	@Named("setGenreDto")
	static GenreDto setGenreDto(MovieDto movieDto) {
		return movieDto.getGenre();
	}

	@Named("setNominationYear")
	static Integer setNominationYear(Movie movie) {
		return movie.getYearOfRelease();
	}
}
