package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CrimesDao;
import dao.Database;
import dto.Crime;

public class CrimeManager {
	
	   private static final String SUCCESS_RESULT="<result>success</result>";
	   private static final String FAILURE_RESULT="<result>failure</result>";
	
	CrimesDao crimesDao = new CrimesDao();
	
	public ArrayList<Crime> getCrimes() throws Exception {
		ArrayList<Crime> crimeList = new ArrayList<Crime>();
		Database db = new Database();
		Connection con = db.getConnection();		
		crimeList = crimesDao.getCrimes(con);
		return crimeList;
	}
	
	public String createNewCrime(Crime crime) throws Exception{
		
		Database db = new Database();
		Connection con = db.getConnection();
		//crimesDao.addCrime(crime, con);
		int result = crimesDao.addCrime(crime, con);
		
			      if(result == 1){
			         return SUCCESS_RESULT;
			      }
			      return FAILURE_RESULT;
				
		
		
	}
	
	
	
}