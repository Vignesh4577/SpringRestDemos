package com.investmentapp.service;

import java.util.List;

import com.investmentapp.exception.PlanNotFoundException;
import com.investmentapp.model.Investment;

public interface IInvestmentService {

	void addInvestment(Investment investment);
	void updateInvestment(int planId,double amount) throws PlanNotFoundException;
	void deleteInvestment(int planId);
	
	List<Investment> getByRiskAndTerm(String risk,int term);
	List<Investment> getByPurpose(String purpose);
	List<Investment> getByType(String type);
	List<Investment> getByAll();
	
	double calculateMaturity(Investment investment);
    Investment getById(int planId) throws PlanNotFoundException;
}
