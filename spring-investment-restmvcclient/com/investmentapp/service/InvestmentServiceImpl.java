package com.investmentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investmentapp.exception.PlanNotFoundException;
import com.investmentapp.model.Investment;
import com.investmentapp.repository.IInvestmentRepository;

@Service
public class InvestmentServiceImpl implements IInvestmentService {

	private IInvestmentRepository iInvestmentRepository;
	
    @Autowired
    public void setiInvestmentRepository(IInvestmentRepository iInvestmentRepository) {
		this.iInvestmentRepository = iInvestmentRepository;
	}

	@Override
	public void addInvestment(Investment investment) {
		iInvestmentRepository.addInvestment(investment);

	}

	@Override
	public void updateInvestment(int planId, double amount) {
		iInvestmentRepository.updateInvestment(planId,amount);
	}

	@Override
	public void deleteInvestment(int planId) {
		iInvestmentRepository.deleteInvestment(planId);

	}

	@Override
	public List<Investment> getByRiskAndTerm(String risk, int term) {
		return iInvestmentRepository.findByRiskAndTerm(risk, term);
	}

	@Override
	public List<Investment> getByPurpose(String purpose) {
		
		return iInvestmentRepository.findByPurpose(purpose);
	}

	@Override
	public List<Investment> getByType(String type) {
		
		return  iInvestmentRepository.findByType(type);
	}

	@Override
	public List<Investment> getByAll() {
	
		return iInvestmentRepository.findByAll();
	}

	@Override
	public double calculateMaturity(Investment investment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Investment getById(int planId) {
		
		Investment investment = iInvestmentRepository.findById(planId);
		if(investment==null)
			throw new PlanNotFoundException("invalid id");
		return investment;
	}

}
