package com.eurodyn.mapper;

import com.eurodyn.dto.UserRatingDto;
import com.eurodyn.model.UserRating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AppUserMapper.class)
public interface UserRatingMapper {
	UserRating dtoToEntity(UserRatingDto dto);

	UserRatingDto entityToDto(UserRating entity);
}
