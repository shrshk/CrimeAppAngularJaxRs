package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Crime;

public class CrimesDao {

	public ArrayList<Crime> getCrimes(Connection con) throws SQLException {
		ArrayList<Crime> crimeList = new ArrayList<Crime>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM crime");
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Crime crimeObj = new Crime();
				crimeObj.setId(rs.getInt("idcrime"));
				crimeObj.setCrimeRegion(rs.getString("Crime_region"));
				crimeObj.setCrimeType(rs.getString("Crime_type"));
				crimeObj.setSuspectDetails(rs.getString("Suspect_details"));
				crimeList.add(crimeObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return crimeList;

	}
	
	public int addCrime(Crime crime, Connection con) throws SQLException{
		
		List<Crime> crimeList = getCrimes(con);
	      boolean crimeExists = false;
	      for(Crime c: crimeList){
	         if(c.getId() == crime.getId()){
	            crimeExists = true;
	            break;
	         }
	      }		
	      if(!crimeExists){
	         //crimeList.add(crime);
	         saveCrimeList(crime, con);
	         return 1;
	      }
	      return 0;
		
	}
	
	private void saveCrimeList(Crime crime, Connection con) throws SQLException{
		String query = " insert into crime (idcrime, Crime_region, Crime_type, Suspect_details)"
	               + " values (?, ?, ?, ?)";
				 
		
		PreparedStatement stmt = con.prepareStatement(query);
		
		
			stmt.setInt(1,crime.getId()); 
			stmt.setString(2, crime.getCrimeRegion());
			stmt.setString(3,crime.getCrimeType());
			stmt.setString(4,crime.getSuspectDetails());
			stmt.execute();
		
		
		
	}

}
