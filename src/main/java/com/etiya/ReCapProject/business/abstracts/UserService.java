package com.etiya.ReCapProject.business.abstracts;

import java.util.List;

import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.ApplicationUser;
import com.etiya.ReCapProject.entities.requests.CreateApplicationUserRequest;
import com.etiya.ReCapProject.entities.requests.DeleteApplicationUserRequest;
import com.etiya.ReCapProject.entities.requests.UpdateApplicationUserRequest;

public interface UserService {
	DataResult<List<ApplicationUser>> getAll();
	
	DataResult<ApplicationUser> getById(int applicationUserId);

	Result add(CreateApplicationUserRequest createApplicationUserRequest);

	Result update(UpdateApplicationUserRequest updateApplicationUserRequest);

	Result delete(DeleteApplicationUserRequest deleteApplicationUserRequest);
	
	DataResult<ApplicationUser> getByEmail(String email);
	
	Result existsByEmail(String email);
}
