package com.etiya.ReCapProject.business.abstracts;

import java.io.IOException;
import java.util.List;


import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.CarImage;
import com.etiya.ReCapProject.entities.requests.create.CreateCarImageRequest;
import com.etiya.ReCapProject.entities.requests.delete.DeleteCarImageRequest;
import com.etiya.ReCapProject.entities.requests.update.UpdateCarImageRequest;

public interface CarImageService {
	DataResult<List<CarImage>> getAll();

	DataResult<CarImage> getById(int carImageId); 
	
	DataResult<List<CarImage>> getCarImagesByCarId(int carId);

	Result add(CreateCarImageRequest createCarImageRequest)throws IOException;

	Result update(UpdateCarImageRequest updateCarImageRequest)throws IOException;

	Result delete(DeleteCarImageRequest deleteCarImageRequest);
}
