package com.etiya.ReCapProject.api.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.RentalAdditionalService;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.RentalAdditional;
import com.etiya.ReCapProject.entities.requests.create.CreateRentalAdditionalRequest;
import com.etiya.ReCapProject.entities.requests.delete.DeleteRentalAdditionalRequest;
import com.etiya.ReCapProject.entities.requests.update.UpdateRentalAdditionalRequest;

@RestController
@RequestMapping("api/rentaladditionals")
public class RentalAdditionalsController {

	private RentalAdditionalService rentalAdditionalService;

	@Autowired
	public RentalAdditionalsController(RentalAdditionalService rentalAdditionalService) {
		super();
		this.rentalAdditionalService = rentalAdditionalService;
	}

	@GetMapping("/getAll")
	public DataResult<List<RentalAdditional>> getAll() {
		return this.rentalAdditionalService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<RentalAdditional> getById(@RequestParam("rentalAdditionalId") int rentalAdditionalId) {
		return this.rentalAdditionalService.getById(rentalAdditionalId);
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateRentalAdditionalRequest createRentalAdditionalRequest) {
		return this.rentalAdditionalService.add(createRentalAdditionalRequest);
	}

	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateRentalAdditionalRequest updateRentalAdditionalRequest) {
		return this.rentalAdditionalService.update(updateRentalAdditionalRequest);
	}

	@PostMapping("/delete")
	public Result delte(DeleteRentalAdditionalRequest deleteRentalAdditionalRequest) {
		return this.rentalAdditionalService.delete(deleteRentalAdditionalRequest);
	}
}