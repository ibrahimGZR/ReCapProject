package com.etiya.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.CityService;
import com.etiya.ReCapProject.core.utilities.business.BusinessRules;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.ErrorResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.dataAccess.abstracts.CityDao;
import com.etiya.ReCapProject.entities.concretes.City;
import com.etiya.ReCapProject.entities.requests.create.CreateCityRequest;
import com.etiya.ReCapProject.entities.requests.delete.DeleteCityRequest;
import com.etiya.ReCapProject.entities.requests.update.UpdateCityRequest;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Şehirler listelendi");
	}

	@Override
	public DataResult<City> getById(int cityId) {
		return new SuccessDataResult<City>(this.cityDao.getById(cityId), "Şehir listelendi");
	}

	@Override
	public Result add(CreateCityRequest createCityRequest) {

		var result = BusinessRules.run(this.checkCityByCityName(createCityRequest.getCityName()));

		if (result != null) {
			return result;
		}

		City city = new City();
		city.setCityName(createCityRequest.getCityName());

		this.cityDao.save(city);
		return new SuccessResult("Şehir eklendi");
	}

	@Override
	public Result update(UpdateCityRequest updateCityRequest) {

		var result = BusinessRules.run(this.checkCityByCityName(updateCityRequest.getCityName()));

		if (result != null) {
			return result;
		}

		City city = this.cityDao.getById(updateCityRequest.getCityId());
		city.setCityName(updateCityRequest.getCityName());

		this.cityDao.save(city);
		return new SuccessResult("Şehir güncellendi");
	}

	@Override
	public Result delete(DeleteCityRequest deleteCityRequest) {

		City city = this.cityDao.getById(deleteCityRequest.getCityId());

		this.cityDao.delete(city);
		return new SuccessResult("Şehir silindi");
	}

	private Result checkCityByCityName(String cityName) {
		if (this.cityDao.existsByCityName(cityName)) {
			return new ErrorResult("Bu şehir bulunmaktadır");
		}
		return new SuccessResult();
	}

}
