package com.etiya.ReCapProject.entities.requests.update;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInvoiceDetailRequest {

	@NotNull
	private int invoiceDetailId;
}