package com.etiya.ReCapProject.entities.requests.create;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationUserRequest {

	@NotBlank
	@NotNull
	@Email
	private String email;

	@NotBlank
	@NotNull
	private String password;
}