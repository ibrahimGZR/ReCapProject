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
public class CreateCardInformationRequest {

	@NotBlank
	@NotNull
	@Size(max = 25)
	private String cardName;

	@NotBlank
	@NotNull
	@Size(min = 16, max = 16)
	private String cardNumber;

	@NotBlank
	@NotNull
	@Size(max = 25)
	private String cardHolderName;

	@NotBlank
	@NotNull
	@Size(min = 5, max = 5)
	private String expirationDate;

	@NotBlank
	@NotNull
	@Size(min = 3, max = 3)
	private String cvv;

	@NotNull
	private int userId;
}