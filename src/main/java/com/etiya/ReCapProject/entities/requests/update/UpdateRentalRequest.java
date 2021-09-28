package com.etiya.ReCapProject.entities.requests.update;

import java.util.Date;

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
	private int carId;

	@NotNull
	private int returnCityId;
	
	@NotNull
	private Date rentDate;
	
	@NotNull
	private Date returnDate;
	
	
}
