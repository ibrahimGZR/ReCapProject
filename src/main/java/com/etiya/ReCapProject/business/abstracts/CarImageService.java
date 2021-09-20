package com.etiya.ReCapProject.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.CarImage;
import com.etiya.ReCapProject.entities.requests.CreateCarImageRequest;
import com.etiya.ReCapProject.entities.requests.DeleteCarImageRequest;
import com.etiya.ReCapProject.entities.requests.UpdateCarImageRequest;

public interface CarImageService {
	DataResult<List<CarImage>> getAll();
	
	DataResult<List<CarImage>> getCarImagesByCarId(int carId);

	Result add(CreateCarImageRequest createCarImageRequest, MultipartFile file)throws IOException;

	Result update(UpdateCarImageRequest updateCarImageRequest);

	Result delete(DeleteCarImageRequest deleteCarImageRequest);
}
