package com.etiya.ReCapProject.api.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.ReCapProject.business.abstracts.UserService;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.entities.concretes.ApplicationUser;

@RestController
@RequestMapping("api/users")
public class UsersController {
	private UserService userService;

	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ApplicationUser>> getAll() {
		return this.userService.getAll();
	}
	
//	@PostMapping("/update")
//	public Result update(@Valid @RequestBody UpdateApplicationUserRequest updateApplicationUserRequest) {
//		return this.userService.update(updateApplicationUserRequest);
//	}
//	
//	@PostMapping("/delete")
//	public Result delete(DeleteApplicationUserRequest deleteApplicationUserRequest) {
//		return this.userService.delete(deleteApplicationUserRequest);
//	}
}
