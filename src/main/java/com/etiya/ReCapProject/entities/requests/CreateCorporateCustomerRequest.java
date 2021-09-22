package com.etiya.ReCapProject.entities.requests;

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
	private String taxNumber;

	@NotNull
	private int userId;
}