package com.etiya.ReCapProject.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.CarImageService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.core.utilities.business.BusinessRules;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.ErrorResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.dataAccess.abstracts.CarImageDao;
import com.etiya.ReCapProject.entities.concretes.Car;
import com.etiya.ReCapProject.entities.concretes.CarImage;
import com.etiya.ReCapProject.entities.requests.CreateCarImageRequest;
import com.etiya.ReCapProject.entities.requests.UpdateCarImageRequest;

@Service
public class CarImageManager implements CarImageService {

	CarImageDao carImageDao;

	@Autowired
	public CarImageManager(CarImageDao carImageDao) {
		super();
		this.carImageDao = carImageDao;
	}

	@Override
	public DataResult<List<CarImage>> getAll() {
		return new SuccessDataResult<List<CarImage>>(this.carImageDao.findAll(), Messages.CarImagesListed);
	}

	@Override
	public Result add(CreateCarImageRequest createCarImageRequest) {
		var result = BusinessRules.run(checkCarImagesCount(createCarImageRequest.getCarId(),5));

		if (result != null) {
			return result;
		}

		Date dateNow = new java.sql.Date(new java.util.Date().getTime());
		String imageRandomName = java.util.UUID.randomUUID().toString();

		Car car = new Car();
		car.setCarId(createCarImageRequest.getCarId());

		CarImage carImage = new CarImage();
		carImage.setImagePath("carImages/" + imageRandomName + ".jpg");
		carImage.setDate(dateNow);

		carImage.setCar(car);

		this.carImageDao.save(carImage);
		return new SuccessResult(Messages.CarImageAdded);
	}

	@Override
	public Result update(UpdateCarImageRequest updateCarImageRequest) {
		var result = BusinessRules.run(checkCarImagesCount(updateCarImageRequest.getCarId(),5));

		if (result != null) {
			return result;
		}

		Date dateNow = new java.sql.Date(new java.util.Date().getTime());
		String imageRandomName = java.util.UUID.randomUUID().toString();

		Car car = new Car();
		car.setCarId(updateCarImageRequest.getCarId());

		CarImage carImage = new CarImage();
		carImage.setCarImageId(updateCarImageRequest.getCarImageId());
		carImage.setImagePath("carImages/" + imageRandomName + ".jpg");
		carImage.setDate(dateNow);

		carImage.setCar(car);
 
		this.carImageDao.save(carImage);
		return new SuccessResult(Messages.CarImageAdded);
	}

	@Override
	public Result delete(int carImageId) {
		this.carImageDao.deleteById(carImageId);
		return new SuccessResult(Messages.CarImageDeleted);
	}

	private Result checkCarImagesCount(int CarId, int limit) {
		if (this.carImageDao.countByCar_CarId(CarId) >= limit) {
			return new ErrorResult(Messages.CarImagesCountOfCarError);
		}
		return new SuccessResult(); 
	}

	@Override
	public DataResult<List<CarImage>> getByCar_CarId(int carId) {
		return new SuccessDataResult<List<CarImage>>(this.carImageDao.getByCar_CarId(carId),Messages.CarImagesListed);
	}

}
