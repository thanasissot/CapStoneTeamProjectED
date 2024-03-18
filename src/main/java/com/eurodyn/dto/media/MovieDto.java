package com.eurodyn.dto.media;

import com.eurodyn.dto.GenreDto;
import com.eurodyn.dto.people.ActorDto;
import com.eurodyn.dto.people.CrewMemberDto;
import com.eurodyn.dto.people.DirectorDto;
import com.eurodyn.dto.people.ProducerDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class MovieDto {
	private String title;
	private BigDecimal productionBudget;
	private Integer yearOfRelease;
	private GenreDto genre;
	private DirectorDto director;
	private Set<ActorDto> actors;
	private Set<ProducerDto> producers;
	private Set<CrewMemberDto> crewMembers;
}
