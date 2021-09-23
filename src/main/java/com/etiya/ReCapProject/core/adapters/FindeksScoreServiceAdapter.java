package com.etiya.ReCapProject.core.adapters;

import org.springframework.stereotype.Service;

import com.etiya.ReCapProject.outServices.FindeksScoreService;

@Service
public class FindeksScoreServiceAdapter implements CustomerFindeksScoreService{
	 FindeksScoreService findeksScoreService = new FindeksScoreService();
	 
	@Override
	public Integer getIndivicualScore(String nationalIdentityNumber) {
		
		return findeksScoreService.getIndivicualScore(nationalIdentityNumber);
	}

	@Override
	public Integer getCorporateScore(String taxNumber) {
		
		return findeksScoreService.getCorporateScore(taxNumber);
	}

}
