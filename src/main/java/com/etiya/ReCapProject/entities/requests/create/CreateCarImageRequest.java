package com.etiya.ReCapProject.entities.requests.create;




import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateCarImageRequest {
	
	@NotNull
	private int carId;
	
	@NotNull
	@NotBlank
	@JsonIgnore
	private MultipartFile file;
	
	
}
