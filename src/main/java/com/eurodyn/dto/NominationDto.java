package com.eurodyn.dto;

import com.eurodyn.dto.media.MovieDto;
import com.eurodyn.dto.people.ActorDto;
import lombok.Data;

import java.util.List;

@Data
public class NominationDto {
	private MovieDto movie;
	private ActorDto actor;
	private GenreDto genre;
	private Integer nominationYear;
	private List<UserRatingDto> userRatings;
}
