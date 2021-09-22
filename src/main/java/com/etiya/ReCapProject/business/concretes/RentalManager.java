package com.etiya.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.CarService;
import com.etiya.ReCapProject.business.abstracts.CustomerService;
import com.etiya.ReCapProject.business.abstracts.RentalService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.core.utilities.business.BusinessRules;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.ErrorResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.dataAccess.abstracts.RentalDao;
import com.etiya.ReCapProject.entities.concretes.Car;
import com.etiya.ReCapProject.entities.concretes.Customer;
import com.etiya.ReCapProject.entities.concretes.Rental;
import com.etiya.ReCapProject.entities.requests.CreateRentalRequest;
import com.etiya.ReCapProject.entities.requests.DeleteRentalRequest;
import com.etiya.ReCapProject.entities.requests.UpdateRentalRequest;

@Service
public class RentalManager implements RentalService {

	private RentalDao rentalDao;
	private CarService carService;
	private CustomerService customerService;

	@Autowired
	public RentalManager(RentalDao rentalDao, CarService carService, CustomerService customerService) {
		super();
		this.rentalDao = rentalDao;
		this.carService = carService;
		this.customerService = customerService;
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
		var result = BusinessRules.run(checkCarIsReturned(createRentalRequest.getCarId()));

		if (result != null) {
			return result;
		}

		Car car = this.carService.getById(createRentalRequest.getCarId()).getData();

		Customer customer = this.customerService.getById(createRentalRequest.getCustomerId()).getData();

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

		Rental rental = this.rentalDao.getById(updateRentalRequest.getRentalId());
		rental.setRentDate(updateRentalRequest.getRentDate());
		rental.setReturnDate(updateRentalRequest.getReturnDate());

		this.rentalDao.save(rental);
		return new SuccessResult(Messages.RentalUpdated);
	}

	@Override
	public Result delete(DeleteRentalRequest deleteRentalRequest) {
		
		Rental rental = this.rentalDao.getById(deleteRentalRequest.getRentalId());

		this.rentalDao.delete(rental);
		return new SuccessResult(Messages.RentalDeleted);
	}

	private Result checkCarIsReturned(int carId) {
		if (this.rentalDao.existsByIsCarReturnedIsFalseAndCar_CarId(carId)) {
			return new ErrorResult(Messages.RentalCarNotReturn);
		}
		return new SuccessResult();
	}

}