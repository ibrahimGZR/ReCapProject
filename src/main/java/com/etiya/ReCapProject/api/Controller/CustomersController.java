package com.etiya.ReCapProject.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.CustomerService;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.Customer;

@RestController
@RequestMapping("api/customers")
public class CustomersController {
	CustomerService customerService;

	@Autowired
	public CustomersController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Customer>> getAll() {
		return this.customerService.getAll();
	}
	
	@GetMapping("/getbyid")
	public DataResult<Customer> getById(int customerId) {
		return this.customerService.getById(customerId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Customer customer) {
		return this.customerService.add(customer);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Customer customer) {
		return this.customerService.update(customer);
	}
	
	@PostMapping("/delete")
	public Result delte(@RequestBody Customer customer) {
		return this.customerService.delete(customer);
	}
}
