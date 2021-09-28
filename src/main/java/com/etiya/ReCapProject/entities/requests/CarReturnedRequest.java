package com.etiya.ReCapProject.entities.requests;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarReturnedRequest {
	
	@NotNull
	private int rentalId;
	
	@NotNull
	private long returnKilometer;
}
