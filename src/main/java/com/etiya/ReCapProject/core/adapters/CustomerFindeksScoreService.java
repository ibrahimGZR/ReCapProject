package com.etiya.ReCapProject.core.adapters;

public interface CustomerFindeksScoreService {

	public Integer getIndivicualScore(String nationalIdentityNumber);

	public Integer getCorporateScore(String taxNumber);

}
