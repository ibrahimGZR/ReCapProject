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
public class UpdateRentalRequest {

	@NotNull
	private int rentalId;
	
	@NotNull
	@NotBlank
	private Date rentDate;
	
	@NotNull
	@NotBlank
	private Date returnDate;
	
	@NotNull
	private int carId;
	
	@NotNull
	private int customerId;
}
