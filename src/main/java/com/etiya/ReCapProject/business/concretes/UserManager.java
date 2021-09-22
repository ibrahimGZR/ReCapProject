package com.etiya.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.UserService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.dataAccess.abstracts.ApplicationUserDao;
import com.etiya.ReCapProject.entities.concretes.ApplicationUser;
import com.etiya.ReCapProject.entities.requests.CreateApplicationUserRequest;
import com.etiya.ReCapProject.entities.requests.DeleteApplicationUserRequest;
import com.etiya.ReCapProject.entities.requests.UpdateApplicationUserRequest;

@Service
public class UserManager implements UserService {

	private ApplicationUserDao applicationUserDao;

	@Autowired
	public UserManager(ApplicationUserDao applicationUserDao) {
		super();
		this.applicationUserDao = applicationUserDao;
	}

	@Override
	public DataResult<List<ApplicationUser>> getAll() {
		return new SuccessDataResult<List<ApplicationUser>>(this.applicationUserDao.findAll(), Messages.UsersListed);
	}
	
	@Override
	public DataResult<ApplicationUser> getById(int applicationUserId) {
		return new SuccessDataResult<ApplicationUser>(this.applicationUserDao.getById(applicationUserId));
	}

	@Override
	public Result add(CreateApplicationUserRequest createApplicationUserRequest) {

		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setFirstName(createApplicationUserRequest.getFirstName());
		applicationUser.setLastName(createApplicationUserRequest.getLastName());
		applicationUser.setEmail(createApplicationUserRequest.getEmail());
		applicationUser.setPassword(createApplicationUserRequest.getPassword());

		this.applicationUserDao.save(applicationUser);
		return new SuccessResult(Messages.UserAdded);
	}

	@Override
	public Result update(UpdateApplicationUserRequest updateApplicationUserRequest) {

		ApplicationUser applicationUser = this.applicationUserDao.getById(updateApplicationUserRequest.getUserId());
		applicationUser.setFirstName(updateApplicationUserRequest.getFirstName());
		applicationUser.setLastName(updateApplicationUserRequest.getLastName());
		applicationUser.setEmail(updateApplicationUserRequest.getEmail());
		applicationUser.setPassword(updateApplicationUserRequest.getPassword());

		this.applicationUserDao.save(applicationUser);
		return new SuccessResult(Messages.UserUpdated);
	}

	@Override
	public Result delete(DeleteApplicationUserRequest deleteApplicationUserRequest) {

		ApplicationUser applicationUser = this.applicationUserDao.getById(deleteApplicationUserRequest.getUserId());

		this.applicationUserDao.delete(applicationUser);
		return new SuccessResult(Messages.UserDeleted);
	}

	

}
