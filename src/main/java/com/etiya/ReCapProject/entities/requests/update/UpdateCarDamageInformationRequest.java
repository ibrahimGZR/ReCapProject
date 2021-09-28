package com.etiya.ReCapProject.entities.requests.update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarDamageInformationRequest {

	@NotNull
	private int carDamageInformationId;

	@NotBlank
	@NotNull
	@Size(max = 250)
	private String description;

}
