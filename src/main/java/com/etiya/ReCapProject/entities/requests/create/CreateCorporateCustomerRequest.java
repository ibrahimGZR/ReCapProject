package com.etiya.ReCapProject.entities.requests.create;

import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCorporateCustomerRequest {

	@NotNull
	private String companyName;

	@NotNull
	@Size(min = 10, max = 10)
	private String taxNumber;

	@NotNull
	private int userId;
}