package com.etiya.ReCapProject.entities.dtos;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDetailDto {

	@NotBlank
	@NotNull
	private String cityName;

}
