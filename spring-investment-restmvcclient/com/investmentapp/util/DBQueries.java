package com.investmentapp.util;

public class DBQueries {

	public static final String INSERTQUERY = "INSERT INTO INVESTMENT(plan_name,entry_age,type,amount,purpose,risk,nominee,term) values(?,?,?,?,?,?,?,?)";
	public static final String UPDATEQUERY = "UPDATE INVESTMENT SET amount=? WHERE plan_id=?";
	public static final String DELETEQUERY = "DELETE FROM INVESTMENT WHERE plan_id=?";
	
	public static final String SELECTQUERY = "SELECT * FROM INVESTMENT";
	public static final String SELECTBYTYPE= "SELECT * FROM INVESTMENT WHERE TYPE=?";
	public static final String SELECTBYPURPOSE = "SELECT * FROM INVESTMENT WHERE PURPOSE=?";
	public static final String SELECTBYRISKTERM = "SELECT * FROM INVESTMENT WHERE RISK=? AND TERM=?";
	public static final String SELECTBYID = "SELECT * FROM INVESTMENT WHERE PLAN_ID=?";


			
    
			
}

