package webService;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.CrimeManager;

import com.google.gson.Gson;

import dto.Crime;

@Path("/crimeService")
public class CrimeService {

	CrimeManager crimeManager = new CrimeManager();

	@GET
	@Path("/crimes")
	@Produces("application/json")
	public Response crimes() {
		String crimes = null;
		ArrayList<Crime> crimeList = new ArrayList<Crime>();
		try {
			crimeList = new CrimeManager().getCrimes();
			Gson gson = new Gson();
			crimes = gson.toJson(crimeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(crimes);
		//return crimes;
		return Response
	            .status(200)	            
	            .entity(crimes)
	            .build();
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	public void createCrime(Crime crime){
		
		//Crime crime = new Crime(crimeRegion, crimeType, suspectDetails, id);
			 

		System.out.println("Adding crime with ID: " + crime.getId());
		//Crime crime = new Crime(crimeRegion, crimeType, suspectDetails, id);
		
		if(crime!=null){
			System.out.println("inside add crime"+crime.toString());
			
			
		

		try {
			crimeManager.createNewCrime(crime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("could not add crime sorry about that");
			e.printStackTrace();
		}
	}
		
	

	}

}
