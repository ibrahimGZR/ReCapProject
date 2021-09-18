package com.etiya.ReCapProject.entities.requests;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarImageRequest {
	
	@NotNull
	private int carImageId;
	
	@NotNull
	private int carId;
}