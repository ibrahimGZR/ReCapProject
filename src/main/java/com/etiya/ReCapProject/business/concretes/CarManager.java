package com.etiya.ReCapProject.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.CarService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.core.utilities.results.*;
import com.etiya.ReCapProject.dataAccess.abstracts.CarDao;
import com.etiya.ReCapProject.entities.concretes.Brand;
import com.etiya.ReCapProject.entities.concretes.Car;
import com.etiya.ReCapProject.entities.concretes.CarImage;
import com.etiya.ReCapProject.entities.concretes.Color;
import com.etiya.ReCapProject.entities.dtos.CarDetailDto;
import com.etiya.ReCapProject.entities.requests.CreateCarRequest;
import com.etiya.ReCapProject.entities.requests.UpdateCarRequest;

@Service
public class CarManager implements CarService {
	CarDao carDao;

	@Autowired
	public CarManager(CarDao carDao) {
		super();
		this.carDao = carDao;
	}

	@Override
	public DataResult<List<Car>> getAll() {

		return new SuccessDataResult<List<Car>>(
				returnCarsWithDefaultImageWhereCarImageIsNull(this.carDao.findAll()).getData(), Messages.CarsListed);
	}

	@Override
	public DataResult<Car> getById(int carId) {

		if (this.returnCarWithDefaultImageIfCarImageIsNull(carId).isSuccess()) {
			return new SuccessDataResult<Car>(this.returnCarWithDefaultImageIfCarImageIsNull(carId).getData(),
					Messages.CarListed);
		}

		return new SuccessDataResult<Car>(this.carDao.getById(carId), Messages.CarListed);

	}

	@Override
	public Result add(CreateCarRequest createCarRequest) {

		Brand brand = new Brand();
		brand.setBrandId(createCarRequest.getBrandId());

		Color color = new Color();
		color.setColorId(createCarRequest.getColorId());

		Car car = new Car();
		car.setCarName(createCarRequest.getCarName());
		car.setDailyPrice(createCarRequest.getDailyPrice());
		car.setModelYear(createCarRequest.getModelYear());
		car.setDescription(createCarRequest.getDescription());

		car.setBrand(brand);
		car.setColor(color);

		this.carDao.save(car);
		return new SuccessResult(Messages.CarAdded);

	}

	@Override
	public Result update(UpdateCarRequest updateCarRequest) {

		Brand brand = new Brand();
		brand.setBrandId(updateCarRequest.getBrandId());

		Color color = new Color();
		color.setColorId(updateCarRequest.getColorId());

		Car car = new Car();
		car.setCarId(updateCarRequest.getCarId());
		car.setCarName(updateCarRequest.getCarName());
		car.setDailyPrice(updateCarRequest.getDailyPrice());
		car.setModelYear(updateCarRequest.getModelYear());
		car.setDescription(updateCarRequest.getDescription());

		car.setBrand(brand);
		car.setColor(color);

		this.carDao.save(car);
		return new SuccessResult(Messages.CarUpdated);

	}

	@Override
	public Result delete(int carId) {

		this.carDao.deleteById(carId);
		return new SuccessResult(Messages.CarDeleted);

	}

	@Override
	public DataResult<List<CarDetailDto>> getAllCarDetails() {

		return new SuccessDataResult<List<CarDetailDto>>(this.carDao.getCarsWithBrandAndColorDetail(),
				Messages.CarDetailsListed);
	}

	private DataResult<Car> returnCarWithDefaultImageIfCarImageIsNull(int carId) {

		if (!this.carDao.existsByCarImagesIsNullAndCarId(carId)) {
			return new ErrorDataResult<Car>();
		}

		CarImage carImage = new CarImage();
		carImage.setImagePath("carImages/default.jpg");

		List<CarImage> carImages = new ArrayList<CarImage>();
		carImages.add(carImage);

		Car car = this.carDao.getById(carId);
		car.setCarImages(carImages);

		return new SuccessDataResult<Car>(car, "Resimi olmayan Araba Default resim ile listelendi");

	}

	private DataResult<List<Car>> returnCarsWithDefaultImageWhereCarImageIsNull(List<Car> cars) {

		CarImage carImage = new CarImage();
		carImage.setImagePath("carImages/default.jpg");

		List<CarImage> carImages = new ArrayList<CarImage>();
		carImages.add(carImage);

		if (this.carDao.existsByCarImagesIsNull()) {
			for (Car car : cars) {
				if (this.carDao.existsByCarImagesIsNullAndCarId(car.getCarId())) {
					car.setCarImages(carImages);
				}
			}
		}

		return new SuccessDataResult<List<Car>>(cars, "Resimleri olmayan arabalar Default resim ile listelendi");

	}
}
