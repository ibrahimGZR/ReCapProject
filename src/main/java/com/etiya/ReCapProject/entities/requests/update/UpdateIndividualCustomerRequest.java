package com.etiya.ReCapProject.entities.requests.update;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIndividualCustomerRequest {

	@NotNull
	private int individualCustomerId;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private String nationalIdentityNumber;
}