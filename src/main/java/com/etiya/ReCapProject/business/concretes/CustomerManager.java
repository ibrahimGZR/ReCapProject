package com.etiya.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.CustomerService;
import com.etiya.ReCapProject.business.abstracts.UserService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.dataAccess.abstracts.ApplicationUserDao;
import com.etiya.ReCapProject.dataAccess.abstracts.CustomerDao;
import com.etiya.ReCapProject.entities.concretes.ApplicationUser;
import com.etiya.ReCapProject.entities.concretes.Customer;
import com.etiya.ReCapProject.entities.requests.CreateCustomerRequest;
import com.etiya.ReCapProject.entities.requests.DeleteCustomerRequest;
import com.etiya.ReCapProject.entities.requests.UpdateCustomerRequest;

@Service
public class CustomerManager implements CustomerService {
	
	private CustomerDao customerDao;
	private UserService userService; 
	
	@Autowired
	public CustomerManager(CustomerDao customerDao, UserService userService) {
		super();
		this.customerDao = customerDao;
		this.userService = userService;
	}

	@Override
	public DataResult<List<Customer>> getAll() {
		return new SuccessDataResult<List<Customer>>(this.customerDao.findAll(), Messages.CustomersListed);
	}

	@Override
	public DataResult<Customer> getById(int customerId) {
		return new SuccessDataResult<Customer>(this.customerDao.getById(customerId), Messages.CustomerListed);
	}

	@Override
	public Result add(CreateCustomerRequest createCustomerRequest) {
		
		ApplicationUser applicationUser = this.userService.getById(createCustomerRequest.getUserId()).getData();
		
		Customer customer = new Customer();
		customer.setCompanyName(createCustomerRequest.getCompanyName());
		
		customer.setApplicationUser(applicationUser);
		
		
		this.customerDao.save(customer);
		return new SuccessResult(Messages.CustomerAdded);
	}

	@Override
	public Result update(UpdateCustomerRequest updateCustomerRequest) {
		
		ApplicationUser applicationUser = this.userService.getById(updateCustomerRequest.getUserId()).getData();
		
		Customer customer = this.customerDao.getById(updateCustomerRequest.getCustomerId());
		customer.setCompanyName(updateCustomerRequest.getCompanyName());
		
		customer.setApplicationUser(applicationUser);
		
		this.customerDao.save(customer);
		return new SuccessResult(Messages.CustomerUpdated);
	}

	@Override
	public Result delete(DeleteCustomerRequest deleteCustomerRequest) {
		
		Customer customer = this.customerDao.getById(deleteCustomerRequest.getCustomerId());
		
		this.customerDao.delete(customer);
		return new SuccessResult(Messages.CustomerDeleted);
	}

}
