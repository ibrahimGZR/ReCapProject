package com.etiya.ReCapProject.entities.requests.create;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalAdditionalRequest {

	@NotNull
	@NotBlank
	private String rentalAdditionalName;

	@NotNull
	@Min(0)
	private double dailyPrice;
}