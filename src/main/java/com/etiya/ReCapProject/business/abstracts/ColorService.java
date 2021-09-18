package com.etiya.ReCapProject.business.abstracts;

import java.util.List;

import com.etiya.ReCapProject.core.utilities.results.*;
import com.etiya.ReCapProject.entities.concretes.Color;
import com.etiya.ReCapProject.entities.requests.CreateColorRequest;
import com.etiya.ReCapProject.entities.requests.UpdateColorRequest;

public interface ColorService {
	DataResult<List<Color>> getAll();

	DataResult<Color> getById(int colorId);

	Result add(CreateColorRequest createColorRequest);

	Result update(UpdateColorRequest updateColorRequest);

	Result delete(int colorId);
}
