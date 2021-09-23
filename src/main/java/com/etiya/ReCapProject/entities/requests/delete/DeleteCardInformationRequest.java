package com.etiya.ReCapProject.entities.requests.delete;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCardInformationRequest {
	
	@NotNull
	private int cardInformationId;
}