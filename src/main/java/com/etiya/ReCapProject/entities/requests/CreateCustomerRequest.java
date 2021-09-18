package com.etiya.ReCapProject.entities.requests;


import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

	
	private String companyName;
	
	@NotNull
	private int userId;
}