package com.investmentapp.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.investmentapp.exceptions.PlanNotFoundException;
import com.investmentapp.model.ApiErrors;
import com.investmentapp.model.Investment;
import com.investmentapp.service.IInvestmentService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("investment-api")
public class InvestmentController {

	IInvestmentService investmentService;

	@Autowired
	public void setInvestmentService(IInvestmentService investmentService) {
		this.investmentService = investmentService;
	}

	@PostMapping("/investments")
	public ResponseEntity<Void> addInvestment( @RequestBody Investment investment) {
		investmentService.addInvestment(investment);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@PutMapping("/investments")
	public ResponseEntity<String> updateInvestment(@RequestBody Investment investment) {
		investmentService.updateInvestment(investment);
		return ResponseEntity.accepted().body("Updated");
	}

	@DeleteMapping("/investments/{planId}")
	public ResponseEntity<Void> deleteInvestment(@PathVariable("planId") int planId) {
		investmentService.deleteInvestment(planId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/investments/risk/{risk}/term/{term}")
	public ResponseEntity<List<Investment>> getByRiskAndTerm(@PathVariable("risk") String risk,
			@PathVariable("term") int mterm) {

		List<Investment> investments = investmentService.getByRiskAndTerm(risk, mterm);
		HttpHeaders headers = new HttpHeaders();

		headers.add("desc", "All Investment!!");
		headers.add("info", "Getting investments from Rest API by Risk And Term");

		ResponseEntity<List<Investment>> responseEntity = new ResponseEntity<List<Investment>>(investments, headers,
				HttpStatus.OK);
		return responseEntity.status(HttpStatus.OK).headers(headers).body(investments);

	}

	@GetMapping("/investments/type")
	public ResponseEntity<List<Investment>> getByType(@RequestParam("type") String type) {
		// response body
		List<Investment> investments = investmentService.getByType(type);
		HttpHeaders headers = new HttpHeaders();

		// responce headers
		headers.add("desc", "All Investment!!");
		headers.add("info", "Getting investment from  Rest API ByType");

		ResponseEntity<List<Investment>> responseEntity = new ResponseEntity<List<Investment>>(investments, headers,
				HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/investments/purpose/{purpose}")
	public ResponseEntity<List<Investment>> getByPurpose(@PathVariable("purpose") String purpose) {
		// response body
		List<Investment> investments = investmentService.getByPurpose(purpose);
		HttpHeaders headers = new HttpHeaders();

		// responce headers
		headers.add("desc", "All Investment!!");
		headers.add("info", "Getting investment from Rest API ByPurpose");

		ResponseEntity<List<Investment>> responseEntity = new ResponseEntity<List<Investment>>(investments, headers,
				HttpStatus.ACCEPTED);
		return responseEntity;
	}

//	http://localhost:8080/investments
	@GetMapping("/investments")
	public ResponseEntity<List<Investment>> getAll() {

		List<Investment> investments = investmentService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Investment!!");
		headers.add("info", "Getting investment from database");
		ResponseEntity<List<Investment>> responseEntity = new ResponseEntity<List<Investment>>(investments, headers,
				HttpStatus.OK);
		return responseEntity;

	}

	@GetMapping("/investments/planId/{id}")
	public ResponseEntity<Investment> getById(@PathVariable("id") int planId) {

		Investment investments = investmentService.getById(planId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "All Investment!!");
		headers.add("info", "Getting investment from database");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(investments);

	}

	@ExceptionHandler(PlanNotFoundException.class)
	public ResponseEntity<Object> handlePlanNotFound(PlanNotFoundException ex) {
		HttpHeaders headers = new HttpHeaders();
		headers.addIfAbsent("Error!!!!", ex.getMessage());
		List<String> errorMsg = new ArrayList<>();
		errorMsg.add(ex.getMessage());
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), ex.getMessage(), HttpStatus.CONFLICT.value(), errorMsg);

		return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body(errors);

	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handlePlanNotFound(Exception ex) {
		HttpHeaders headers = new HttpHeaders();
		headers.addIfAbsent("Error!!!!", ex.getMessage());
		List<String> errorMsg = new ArrayList<>();
		errorMsg.add(ex.getMessage());
		ApiErrors errors = new ApiErrors(LocalDateTime.now(), ex.getMessage(), HttpStatus.CONFLICT.value(), errorMsg);

		return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body(errors);

	}
	
	@PutMapping("/investments/planId/{id}/amount/{amount}")
	public ResponseEntity<Void> updateInvestment(
			@PathVariable("id") int planId,@PathVariable("amount") double amount) {

	    investmentService.updateInvestmentAmount(planId, amount);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@GetMapping("/investments/plan-types")
	public ResponseEntity<List<String>> getAllTypes() {

		List<String> planTypes = investmentService.getAllTypes();
		return ResponseEntity.ok().body(planTypes);

	}
	

	@GetMapping("/investments/risk/{risk}")
	public ResponseEntity<List<Investment>> getByRisk(@PathVariable("risk") String risk) {

		List<Investment> investments = investmentService.getByRisk(risk);
		HttpHeaders headers = new HttpHeaders();

		headers.add("desc", "All Investment!!");
		headers.add("info", "Getting investments from Rest API by Risk");

		ResponseEntity<List<Investment>> responseEntity = new ResponseEntity<List<Investment>>(investments, headers,
				HttpStatus.OK);
		return responseEntity.status(HttpStatus.OK).headers(headers).body(investments);

	}
		
}
