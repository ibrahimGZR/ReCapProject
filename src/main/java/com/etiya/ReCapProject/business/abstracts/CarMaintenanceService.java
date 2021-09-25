package com.etiya.ReCapProject.business.abstracts;

import java.util.List;

import com.etiya.ReCapProject.core.utilities.results.DataResult;
import com.etiya.ReCapProject.core.utilities.results.Result;
import com.etiya.ReCapProject.entities.concretes.CarMaintenance;
import com.etiya.ReCapProject.entities.requests.create.CreateCarMaintenanceRequest;
import com.etiya.ReCapProject.entities.requests.delete.DeleteCarMaintenanceRequest;
import com.etiya.ReCapProject.entities.requests.update.UpdateCarMaintenanceRequest;

public interface CarMaintenanceService {
	DataResult<List<CarMaintenance>> getAll();

	DataResult<CarMaintenance> getById(int carMaintenanceId);
	
	//DataResult<RentalDetailDto> getRentalDetailsByRentalId(int rentalId);

	Result add(CreateCarMaintenanceRequest createCarMaintenanceRequest);

	Result update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest);

	Result delete(DeleteCarMaintenanceRequest deleteCarMaintenanceRequest);
	
	Result CarAtMaintenanceReturnedIsTrue(int carMaintenanceId);
}
