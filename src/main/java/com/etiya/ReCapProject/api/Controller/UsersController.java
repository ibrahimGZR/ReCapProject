package com.etiya.ReCapProject.api.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.UserService;
import com.etiya.ReCapProject.core.entities.concretes.User;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;

@RestController
@RequestMapping("api/users")
public class UsersController {
	UserService userService;

	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody User user) {
		return this.userService.add(user);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody User user) {
		return this.userService.update(user);
	}
	
	@PostMapping("/delete")
	public Result delte(@RequestBody User user) {
		return this.userService.delete(user);
	}
}
