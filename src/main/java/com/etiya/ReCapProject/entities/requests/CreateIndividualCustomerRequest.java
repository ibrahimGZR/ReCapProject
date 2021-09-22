package com.etiya.ReCapProject.entities.requests;


import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualCustomerRequest {

	@NotBlank
	@NotNull
	private String firstName;

	@NotBlank
	@NotNull
	private String lastName;
	
	@NotBlank
	@NotNull
	private String nationalIdentityNumber;
	
	@NotNull
	private int userId;
}