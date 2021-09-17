package com.etiya.ReCapProject.business.abstracts;

import java.util.List;

import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.Customer;
import com.etiya.ReCapProject.entities.requests.CreateCustomerRequest;

public interface CustomerService {
	DataResult<List<Customer>> getAll();

	DataResult<Customer> getById(int customerId);
	
	Result add(CreateCustomerRequest createCustomerRequest);

	Result update(CreateCustomerRequest createCustomerRequest);

	Result delete(int customerId);
}
