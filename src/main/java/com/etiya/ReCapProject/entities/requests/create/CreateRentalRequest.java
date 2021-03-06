package com.etiya.ReCapProject.entities.requests.create;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.etiya.ReCapProject.entities.dtos.CardInformationDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {

	@JsonIgnore
	private int rentalId;

	@NotNull
	private Date rentDate;

	@NotNull
	private Date returnDate;

	boolean isShouldCardBeSaved;

	@NotNull
	private int carId;

	@NotNull
	private int userId;

	@NotNull
	private int returnCityId;

	@NotNull
	private List<Integer> rentalAdditionalsId;

	@NotNull
	@Valid
	private CardInformationDto cardInformationDto;
}
