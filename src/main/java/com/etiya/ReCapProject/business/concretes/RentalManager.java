package com.etiya.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.RentalService;
import com.etiya.ReCapProject.core.utilities.business.BusinessRules;
import com.etiya.ReCapProject.core.utilities.results.*;
import com.etiya.ReCapProject.dataAccess.abstracts.RentalDao;
import com.etiya.ReCapProject.entities.concretes.Rental;

@Service
public class RentalManager implements RentalService {

	RentalDao rentalDao;

	@Autowired
	public RentalManager(RentalDao rentalDao) {
		super();
		this.rentalDao = rentalDao;
	}

	@Override
	public DataResult<List<Rental>> getAll() {
		return new SuccessDataResult<List<Rental>>(this.rentalDao.findAll());
	}

	@Override
	public DataResult<Rental> getById(int rentalId) {
		return new SuccessDataResult<Rental>(this.rentalDao.getById(rentalId));
	}

	@Override
	public Result add(Rental rental) {
		var result = BusinessRules.run(checkCarIsReturned(rental.getCar().getCarId()));

		if (result != null) {
			return result;
		}
		this.rentalDao.save(rental);
		return new SuccessResult();
	}

	@Override
	public Result update(Rental rental) {
		this.rentalDao.save(rental);
		return new SuccessResult();
	}

	@Override
	public Result delete(Rental rental) {
		this.rentalDao.delete(rental);
		return new SuccessResult();
	}

	private Result checkCarIsReturned(int carId) {
		List<Rental> rentals = this.rentalDao.getByCar_CarId(carId);
		if (rentals != null) {
			for (Rental rental : this.rentalDao.getByCar_CarId(carId)) {
				if (rental.getReturnDate() == null) {
					return new ErrorResult("Araç hala müşteride teslim edilmedi");
				}
			}
		}
		return new SuccessResult();
	}

}