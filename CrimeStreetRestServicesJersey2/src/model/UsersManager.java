package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.Database;
import dao.UsersDao;
import dto.User;

public class UsersManager {

	public ArrayList<User> getUsers() throws Exception
	{
	ArrayList<User> usersList = new ArrayList<User>();
	Database db = new Database();
	Connection con = db.getConnection();
	UsersDao usersDao = new UsersDao();
	usersList = usersDao.getUsers(con);
	return usersList;
	}
	
	
}
