package com.etiya.ReCapProject.api.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.UserService;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.ApplicationUser;
import com.etiya.ReCapProject.entities.requests.CreateApplicationUserRequest;

@RestController
@RequestMapping("api/users")
public class UsersController {
	UserService userService;

	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ApplicationUser>> getAll() {
		return this.userService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateApplicationUserRequest createApplicationUserRequest) {
		return this.userService.add(createApplicationUserRequest);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody CreateApplicationUserRequest createApplicationUserRequest) {
		return this.userService.update(createApplicationUserRequest);
	}
	
	@PostMapping("/delete")
	public Result delete(int UserId) {
		return this.userService.delete(UserId);
	}
}