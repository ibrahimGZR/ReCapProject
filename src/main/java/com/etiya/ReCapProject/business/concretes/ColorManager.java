package com.etiya.ReCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.business.abstracts.ColorService;
import com.etiya.ReCapProject.core.utilities.results.*;
import com.etiya.ReCapProject.dataAccess.abstracts.ColorDao;
import com.etiya.ReCapProject.entities.concretes.Color;

@Service
public class ColorManager implements ColorService{

	ColorDao colorDao;
	
	@Autowired
	public ColorManager(ColorDao colorDao) {
		super();
		this.colorDao = colorDao;
	}

	@Override
	public DataResult<List<Color>> getAll() {
		return new SuccessDataResult<List<Color>>(this.colorDao.findAll());
	}

	@Override
	public DataResult<Color> getById(int colorId) {
		return new SuccessDataResult<Color>(this.colorDao.getById(colorId));
	}

	@Override
	public Result add(Color color) {
		this.colorDao.save(color);
		return new SuccessResult();
		
	}

	@Override
	public Result update(Color color) {
		this.colorDao.save(color);
		return new SuccessResult();
	}

	@Override
	public Result delete(Color color) {
		this.colorDao.delete(color);
		return new SuccessResult();
	}
}
