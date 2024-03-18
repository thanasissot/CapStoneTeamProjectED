package com.eurodyn.mapper;

import com.eurodyn.dto.people.CrewMemberDto;
import com.eurodyn.model.people.CrewMember;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CrewMemberMapper {
	CrewMember dtoToEntity(CrewMemberDto dto);

	CrewMemberDto entityToDto(CrewMember entity);
}
