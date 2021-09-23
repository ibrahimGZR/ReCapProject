package com.etiya.ReCapProject.entities.requests.update;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateColorRequest {
	
	@NotNull
	private int colorId;
	
	@NotNull
	@NotBlank
	private String colorName;
}
