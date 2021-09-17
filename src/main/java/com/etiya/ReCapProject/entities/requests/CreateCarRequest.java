package com.etiya.ReCapProject.entities.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {

	
	private String carName;

	@NotNull
	@NotBlank
	private String modelYear;

	@NotNull
	@Min(0)
	private double dailyPrice;
	
	@Size(max = 100)
	private String description;

	@NotNull
	@NotBlank
	private int brandId;

	@NotNull
	@NotBlank
	private int colorId;
}
