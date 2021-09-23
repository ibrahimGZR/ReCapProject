package com.etiya.ReCapProject.entities.requests.update;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCorporateCustomerRequest {
	@NotNull
	private int corporateCustomerId;

	@NotNull
	private String companyName;

	@NotNull
	private String taxNumber;

	@NotNull
	private int userId;
}