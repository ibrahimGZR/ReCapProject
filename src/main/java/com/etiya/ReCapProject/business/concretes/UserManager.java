package com.etiya.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.ModelMapperService;
import com.etiya.ReCapProject.business.abstracts.UserService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.core.utilities.business.BusinessRules;
import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.ErrorResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.core.utilities.results.SuccessDataResult;
import com.etiya.ReCapProject.core.utilities.results.SuccessResult;
import com.etiya.ReCapProject.dataAccess.abstracts.ApplicationUserDao;
import com.etiya.ReCapProject.entities.concretes.ApplicationUser;
import com.etiya.ReCapProject.entities.requests.create.CreateApplicationUserRequest;
import com.etiya.ReCapProject.entities.requests.delete.DeleteApplicationUserRequest;
import com.etiya.ReCapProject.entities.requests.update.UpdateApplicationUserRequest;

@Service
public class UserManager implements UserService {

	private ApplicationUserDao applicationUserDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public UserManager(ApplicationUserDao applicationUserDao, ModelMapperService modelMapperService) {
		super();
		this.applicationUserDao = applicationUserDao;
		this.modelMapperService = modelMapperService;
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

		var result = BusinessRules.run(this.existsByEmail(createApplicationUserRequest.getEmail()));

		if (result != null) {
			return result;
		}

		ApplicationUser applicationUser = modelMapperService.forRequest().map(createApplicationUserRequest,
				ApplicationUser.class);

		this.applicationUserDao.save(applicationUser);

		return new SuccessResult(Messages.UserAdded);
	}

	@Override
	public Result update(UpdateApplicationUserRequest updateApplicationUserRequest) {

		var result = BusinessRules.run(this.existsByEmail(updateApplicationUserRequest.getEmail()));

		if (result != null) {
			return result;
		}

		ApplicationUser applicationUser = modelMapperService.forRequest().map(updateApplicationUserRequest,
				ApplicationUser.class);

		this.applicationUserDao.save(applicationUser);
		return new SuccessResult(Messages.UserUpdated);
	}

	@Override
	public Result delete(DeleteApplicationUserRequest deleteApplicationUserRequest) {

		ApplicationUser applicationUser = modelMapperService.forRequest().map(deleteApplicationUserRequest,
				ApplicationUser.class);

		this.applicationUserDao.delete(applicationUser);
		return new SuccessResult(Messages.UserDeleted);
	}

	@Override
	public DataResult<ApplicationUser> getByEmail(String email) {

		return new SuccessDataResult<ApplicationUser>(this.applicationUserDao.getByEmail(email));
	}

	@Override
	public Result existsByEmail(String email) {

		if (this.applicationUserDao.existsByEmail(email)) {
			return new ErrorResult(Messages.EmailAlreadyExists);
		}
		return new SuccessResult();
	}

}
