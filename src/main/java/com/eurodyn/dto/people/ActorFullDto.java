package com.eurodyn.dto.people;

import com.eurodyn.dto.NominationForActorDto;
import com.eurodyn.dto.media.MovieDto;
import com.eurodyn.model.people.Person;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
public class ActorFullDto {
	private String name;
	private BigDecimal salary;
	private Person.SalaryType type;
	private List<NominationForActorDto> nominations;
	private Set<MovieDto> mediaActors;
}
