package com.investmentapp.repository;

import java.util.List;

import com.investmentapp.model.Investment;

public interface IInvestmentRepository {

	void addInvestment(Investment investment);
	void updateInvestment(int planId,double amount);
	void deleteInvestment(int planId);
	
	List<Investment> findByRiskAndTerm(String risk,int term);
	List<Investment> findByPurpose(String purpose);
	List<Investment> findByType(String type);
	List<Investment> findByAll();
	
	Investment findById(int planId);
	//double getById(Investment investment);
}
