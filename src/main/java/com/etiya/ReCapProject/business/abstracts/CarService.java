package com.etiya.ReCapProject.business.abstracts;

import java.util.List;

import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.Car;
import com.etiya.ReCapProject.entities.dtos.CarDetailDto;
import com.etiya.ReCapProject.entities.requests.create.CreateCarRequest;
import com.etiya.ReCapProject.entities.requests.delete.DeleteCarRequest;
import com.etiya.ReCapProject.entities.requests.update.UpdateCarRequest;

public interface CarService {
	DataResult<List<Car>> getAll();

	DataResult<Car> getById(int carId);

	Result add(CreateCarRequest createCarRequest);

	Result update(UpdateCarRequest updateCarRequest);

	Result delete(DeleteCarRequest deleteCarRequest);

	DataResult<List<CarDetailDto>> getAllCarsDetails();

	DataResult<CarDetailDto> getCarDetailsByCarId(int carId);

	DataResult<List<Car>> getCarsByColorId(int colorId);

	DataResult<List<Car>> getCarsByBrandId(int brandId);

	Result checkCarIsInGallery(int carId);

	Result carListedIsTrue(int carId);

	Result carListedIsFalse(int carId);

	DataResult<List<Car>> getCarsByCity_CityId(int cityId);
}
