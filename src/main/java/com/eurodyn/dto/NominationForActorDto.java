package com.eurodyn.dto;

import com.eurodyn.dto.media.MovieDto;
import lombok.Data;

import java.util.List;

@Data
public class NominationForActorDto {
	private MovieDto movie;
	private GenreDto genre;
	private Integer nominationYear;
	private List<UserRatingDto> userRatings;
}
