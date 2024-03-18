package com.eurodyn.mapper;

import com.eurodyn.dto.people.ProducerDto;
import com.eurodyn.model.people.Producer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProducerMapper {
	Producer dtoToEntity(ProducerDto dto);

	ProducerDto entityToDto(Producer entity);
}
