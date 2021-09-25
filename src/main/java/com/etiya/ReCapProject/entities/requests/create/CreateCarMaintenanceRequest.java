package com.etiya.ReCapProject.entities.requests.create;

import java.util.Date;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarMaintenanceRequest {

	@NotNull
	private Date maintenanceDate;
	
	@NotNull
	private Date returnDate;
	
	@NotNull
	private String description;
	
	@NotNull
	private int carId;
}
