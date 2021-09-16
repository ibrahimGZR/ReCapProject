package com.etiya.ReCapProject.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.CarService;
import com.etiya.ReCapProject.entities.concretes.Car;
import com.etiya.ReCapProject.entities.dtos.CarDetailDto;

@RestController
@RequestMapping("api/cars")
public class CarsController {
	CarService carService;

	@Autowired
	public CarsController(CarService carService) {
		super();
		this.carService = carService;
	}
	
	@GetMapping("/getAll")
	public List<Car> getAll() {
		return this.carService.getAll();
	}
	
	@GetMapping("/getcarsDetails")
	public List<CarDetailDto> getCarsDetails() {
		return this.carService.getAllCarDetails();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Car car) {
		this.carService.add(car);
	}
}
