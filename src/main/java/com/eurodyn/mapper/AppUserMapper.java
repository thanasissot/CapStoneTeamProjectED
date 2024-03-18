package com.eurodyn.mapper;

import com.eurodyn.dto.AppUserDto;
import com.eurodyn.model.AppUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
	AppUser dtoToEntity(AppUserDto dto);

	AppUserDto entityToDto(AppUser entity);
}
