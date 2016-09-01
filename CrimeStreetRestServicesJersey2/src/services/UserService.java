package services;

import java.util.ArrayList;

import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.UsersManager;
import dto.User;

@Path("/userService")
public class UserService {	
	 
	
	@GET
	@Path("/users")
	@Produces("application/json")
	public String users()
	{
	String users = null;
	ArrayList<User> usersList = new ArrayList<User>();
	try
	{
	usersList = new UsersManager().getUsers();
	Gson gson = new Gson();
	users = gson.toJson(usersList);
	} catch (Exception e)
	{
	e.printStackTrace();
	}
	System.out.println(users);
	return users;
	}


	


}
