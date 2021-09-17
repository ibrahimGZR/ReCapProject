package com.etiya.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.ColorService;
import com.etiya.ReCapProject.business.constants.Messages;
import com.etiya.ReCapProject.core.utilities.results.*;
import com.etiya.ReCapProject.dataAccess.abstracts.ColorDao;
import com.etiya.ReCapProject.entities.concretes.Color;
import com.etiya.ReCapProject.entities.requests.CreateColorRequest;

@Service
public class ColorManager implements ColorService {

	ColorDao colorDao;

	@Autowired
	public ColorManager(ColorDao colorDao) {
		super();
		this.colorDao = colorDao;
	}

	@Override
	public DataResult<List<Color>> getAll() {
		return new SuccessDataResult<List<Color>>(this.colorDao.findAll(), Messages.ColorsListed);
	}

	@Override
	public DataResult<Color> getById(int colorId) {
		return new SuccessDataResult<Color>(this.colorDao.getById(colorId), Messages.ColorListed);
	}

	@Override
	public Result add(CreateColorRequest createColorRequest) {

		Color color = new Color();
		color.setColorName(createColorRequest.getColorName());

		this.colorDao.save(color);
		return new SuccessResult(Messages.ColorAdded);

	}

	@Override
	public Result update(CreateColorRequest createColorRequest) {

		Color color = new Color();
		color.setColorName(createColorRequest.getColorName());

		this.colorDao.save(color);
		return new SuccessResult(Messages.ColorUpdated);
	}

	@Override
	public Result delete(int colorId) {
		this.colorDao.deleteById(colorId);
		return new SuccessResult(Messages.ColorDeleted);
	}
}
