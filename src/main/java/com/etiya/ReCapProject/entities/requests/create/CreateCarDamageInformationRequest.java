package com.etiya.ReCapProject.entities.requests.create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarDamageInformationRequest {

	@JsonIgnore
	private int carDamageInformationId;
	
	@NotBlank
	@NotNull
	@Size(max = 250)
	private String description;

	@NotNull
	private int carId;
}
