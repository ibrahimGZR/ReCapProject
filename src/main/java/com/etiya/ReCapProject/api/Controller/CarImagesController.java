package com.etiya.ReCapProject.api.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.CarImageService;
import com.etiya.ReCapProject.core.utilities.results.*;
import com.etiya.ReCapProject.entities.concretes.CarImage;
import com.etiya.ReCapProject.entities.requests.CreateCarImageRequest;
import com.etiya.ReCapProject.entities.requests.DeleteCarImageRequest;
import com.etiya.ReCapProject.entities.requests.UpdateCarImageRequest;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/carimages")
public class CarImagesController {
	CarImageService carImageService;

	@Autowired
	public CarImagesController(CarImageService carImageService) {
		super();
		this.carImageService = carImageService;
	}

	@GetMapping("/getAll")
	public DataResult<List<CarImage>> getAll() {
		return this.carImageService.getAll();
	}

	@GetMapping("/getbycarid")
	public DataResult<List<CarImage>> getByCar_CarId(int carId) {
		return this.carImageService.getCarImagesByCarId(carId);
	}

	@PostMapping("/add")
	public Result add(@Valid CreateCarImageRequest createCarImageRequest, MultipartFile file) throws IOException {
		System.out.println(); 
		return this.carImageService.add(createCarImageRequest, file);
	}

	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateCarImageRequest updateCarImageRequest) {
		return this.carImageService.update(updateCarImageRequest);
	}

	@PostMapping("/delete")
	public Result delete(DeleteCarImageRequest deleteCarImageRequest) {
		return this.carImageService.delete(deleteCarImageRequest);
	}
}
