package com.etiya.ReCapProject.entities.requests.update;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCardInformationRequest {

	@NotNull
	private int cardInformationId;
	
	@NotBlank
	@NotNull
	private String cardName;

	@NotBlank
	@NotNull
	private String cardNumber;
	
	@NotBlank
	@NotNull
	private String expirationDate;
	
	@NotBlank
	@NotNull
	private String cvv;
}