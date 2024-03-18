package com.eurodyn.dto.people;

import com.eurodyn.model.people.Person;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActorDto {
	private String name;
	private BigDecimal salary;
	private Person.SalaryType type;
}
