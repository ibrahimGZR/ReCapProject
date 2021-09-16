package com.etiya.ReCapProject.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.RentalService;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.Rental;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {
	RentalService rentalService;

	@Autowired
	public RentalsController(RentalService rentalService) {
		super();
		this.rentalService = rentalService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Rental>> getAll() {
		return this.rentalService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<Rental> getById(int rentalId) {
		return this.rentalService.getById(rentalId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Rental rental) {
		return this.rentalService.add(rental);
	}

	@PostMapping("/update")
	public Result update(@RequestBody Rental rental) {
		return this.rentalService.update(rental);
	}

	@PostMapping("/delete")
	public Result delte(@RequestBody Rental rental) {
		return this.rentalService.delete(rental);
	}
}
