package com.etiya.ReCapProject.entities.requests;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {

	@NotNull
	@NotBlank
	private Date rentDate;
	
	@NotNull
	@NotBlank
	private Date returnDate;
	
	@NotNull
	@NotBlank
	private int carId;
	
	@NotNull
	@NotBlank
	private int customerId;
}
