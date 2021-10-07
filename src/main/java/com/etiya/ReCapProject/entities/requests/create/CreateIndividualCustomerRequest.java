package com.etiya.ReCapProject.entities.requests.create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	@Size(min = 11, max = 11)
	private String nationalIdentityNumber;

	@NotNull
	private int userId;
}