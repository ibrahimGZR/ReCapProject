package com.etiya.ReCapProject.entities.requests;

import java.util.Date;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceBetweenDateRequest {

	@NotNull
	private Date minDate;

	@NotNull
	private Date maxDate;

}
