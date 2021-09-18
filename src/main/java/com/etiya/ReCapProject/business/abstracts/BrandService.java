package com.etiya.ReCapProject.business.abstracts;

import java.util.List;

import com.etiya.ReCapProject.core.utilities.results.*;
import com.etiya.ReCapProject.entities.concretes.Brand;
import com.etiya.ReCapProject.entities.requests.CreateBrandRequest;
import com.etiya.ReCapProject.entities.requests.UpdateBrandRequest;

public interface BrandService {
	DataResult<List<Brand>> getAll();
	
	DataResult<Brand> getById(int brandId);

	Result add(CreateBrandRequest createBrandRequest);

	Result update(UpdateBrandRequest updateBrandRequest);

	Result delete(int brandId);
}
