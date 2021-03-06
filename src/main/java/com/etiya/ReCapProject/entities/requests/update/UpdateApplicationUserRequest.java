package com.etiya.ReCapProject.entities.requests.update;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationUserRequest {
	
	
	@NotNull
	private int userId;
	
	@NotNull
	@NotBlank
	private String firstName;
	
	@NotBlank
	@NotNull
	private String lastName;

	@NotBlank
	@NotNull
	@Email
	private String email;

	@NotBlank
	@NotNull
	private String password;
	
	@NotBlank
	@NotNull
	private String passwordConfirm;
}