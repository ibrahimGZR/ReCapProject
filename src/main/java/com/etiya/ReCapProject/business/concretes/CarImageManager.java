package com.etiya.ReCapProject.business.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.etiya.ReCapProject.business.abstracts.CarImageService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.core.utilities.business.BusinessRules;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.ErrorDataResult;
import com.etiya.ReCapProject.core.utilities.results.ErrorResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.dataAccess.abstracts.CarImageDao;
import com.etiya.ReCapProject.entities.concretes.Car;
import com.etiya.ReCapProject.entities.concretes.CarImage;
import com.etiya.ReCapProject.entities.requests.CreateCarImageRequest;
import com.etiya.ReCapProject.entities.requests.DeleteCarImageRequest;
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
	public Result add(CreateCarImageRequest createCarImageRequest, MultipartFile file) throws IOException {
		var result = BusinessRules.run(checkCarImagesCount(createCarImageRequest.getCarId(), 5), checkImageIsNull(file),
				checkImageType(file));

		if (result != null) {
			return result;
		}

		Date dateNow = new java.sql.Date(new java.util.Date().getTime());
		String imageRandomName = java.util.UUID.randomUUID().toString();

		File myFile = new File("C:\\Users\\ibrahim.gezer\\Desktop\\img\\" + imageRandomName + "."
				+ file.getContentType().toString().substring(6));
		myFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(myFile);
		fos.write(file.getBytes());
		fos.close();

		Car car = new Car();
		car.setCarId(createCarImageRequest.getCarId());

		CarImage carImage = new CarImage();
		carImage.setImagePath(myFile.toString());
		carImage.setDate(dateNow);

		carImage.setCar(car);

		this.carImageDao.save(carImage);
		return new SuccessResult(Messages.CarImageAdded);

	}

	@Override
	public Result update(UpdateCarImageRequest updateCarImageRequest) {
		var result = BusinessRules.run(checkCarImagesCount(updateCarImageRequest.getCarId(), 5));

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
	public Result delete(DeleteCarImageRequest deleteCarImageRequest) {
		CarImage carImage = new CarImage();
		carImage.setCarImageId(deleteCarImageRequest.getCarImageId());

		this.carImageDao.delete(carImage);
		return new SuccessResult(Messages.CarImageDeleted);
	}

	private Result checkCarImagesCount(int CarId, int limit) {
		if (this.carImageDao.countByCar_CarId(CarId) >= limit) {
			return new ErrorResult(Messages.CarImagesCountOfCarError);
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CarImage>> getCarImagesByCarId(int carId) {

		return new SuccessDataResult<List<CarImage>>(returnCarImageWithDefaultImageIfCarImageIsNull(carId).getData(),
				Messages.CarImagesListed);
	}

	private DataResult<List<CarImage>> returnCarImageWithDefaultImageIfCarImageIsNull(int carId) {

		if (this.carImageDao.existsByCar_CarId(carId)) {
			return new ErrorDataResult<List<CarImage>>(this.carImageDao.getByCar_CarId(carId));
		}

		List<CarImage> carImages = new ArrayList<CarImage>();
		CarImage carImage = new CarImage();
		carImage.setImagePath("C:\\Users\\ibrahim.gezer\\Desktop\\img\\default.jpg");

		carImages.add(carImage);

		return new SuccessDataResult<List<CarImage>>(carImages, "Resimi olmayan Araba Default resim ile listelendi");

	}

	private Result checkImageType(MultipartFile file) {
		if (file == null || file.isEmpty()) {
			return new ErrorResult();
		}
		if (file.getContentType().toString().substring(6) != "jpeg"
				&& file.getContentType().toString().substring(6) != "jpg"
				&& file.getContentType().toString().substring(6) != "png") {
			return new ErrorResult("Lütfen jpeg, jpg, png uzantılı resim seçiniz");
		}
		return new SuccessResult();

	}

	private Result checkImageIsNull(MultipartFile file) {
		if (file == null) {
			return new ErrorResult("Herhangi bir resim seçmediniz");
		}
		return new SuccessResult();
	}

}
