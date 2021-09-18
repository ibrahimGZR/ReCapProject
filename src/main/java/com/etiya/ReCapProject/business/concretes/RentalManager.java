package com.etiya.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.RentalService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.core.utilities.business.BusinessRules;
import com.etiya.ReCapProject.core.utilities.results.*;
import com.etiya.ReCapProject.dataAccess.abstracts.RentalDao;
import com.etiya.ReCapProject.entities.concretes.Car;
import com.etiya.ReCapProject.entities.concretes.Customer;
import com.etiya.ReCapProject.entities.concretes.Rental;
import com.etiya.ReCapProject.entities.requests.CreateRentalRequest;
import com.etiya.ReCapProject.entities.requests.UpdateRentalRequest;

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
		return new SuccessDataResult<List<Rental>>(this.rentalDao.findAll(), Messages.RentalsListed);
	}

	@Override
	public DataResult<Rental> getById(int rentalId) {
		return new SuccessDataResult<Rental>(this.rentalDao.getById(rentalId), Messages.RentalListed);
	}

	@Override
	public Result add(CreateRentalRequest createRentalRequest) {
		var result = BusinessRules.run(checkCarIsReturned());

		if (result != null) {
			return result;
		}

		Car car = new Car();
		car.setCarId(createRentalRequest.getCarId());

		Customer customer = new Customer();
		customer.setCustomerId(createRentalRequest.getCustomerId());

		Rental rental = new Rental();
		rental.setRentDate(createRentalRequest.getRentDate());
		rental.setReturnDate(createRentalRequest.getReturnDate());

		rental.setCar(car);
		rental.setCustomer(customer);

		this.rentalDao.save(rental);
		return new SuccessResult(Messages.RentalAdded);
	}

	@Override
	public Result update(UpdateRentalRequest updateRentalRequest) {

		Car car = new Car();
		car.setCarId(updateRentalRequest.getCarId());

		Customer customer = new Customer();
		customer.setCustomerId(updateRentalRequest.getCustomerId());

		Rental rental = new Rental();
		rental.setRentalId(updateRentalRequest.getRentalId());
		rental.setRentDate(updateRentalRequest.getRentDate());
		rental.setReturnDate(updateRentalRequest.getReturnDate());

		rental.setCar(car);
		rental.setCustomer(customer);

		this.rentalDao.save(rental);
		return new SuccessResult(Messages.RentalUpdated);
	}

	@Override
	public Result delete(int rentalId) {
		this.rentalDao.deleteById(rentalId);
		return new SuccessResult(Messages.RentalDeleted);
	}

	private Result checkCarIsReturned() {
		if (this.rentalDao.existsByIsCarReturnedIsFalse()) {
			return new ErrorResult(Messages.RentalCarNotReturn);
		}
		return new SuccessResult();
	}

}