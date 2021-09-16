package com.etiya.ReCapProject.business.abstracts;

import java.util.List;

import com.etiya.ReCapProject.core.utilities.results.*;
import com.etiya.ReCapProject.entities.concretes.Brand;

public interface BrandService {
	DataResult<List<Brand>> getAll();
	
	DataResult<Brand> getById(int brandId);

	Result add(Brand brand);

	Result update(Brand brand);

	Result delete(Brand brand);
}
