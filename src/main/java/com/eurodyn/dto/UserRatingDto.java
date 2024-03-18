package com.eurodyn.dto;

import lombok.Data;

@Data
public class UserRatingDto {
	private AppUserDto appUser;
	private Float rating;
}
