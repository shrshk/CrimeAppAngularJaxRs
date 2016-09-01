package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.User;

public class UsersDao {
	
	public ArrayList<User> getUsers(Connection con) throws SQLException
	{
	ArrayList<User> usersList = new ArrayList<User>();
	PreparedStatement stmt = con.prepareStatement("SELECT * FROM users");
	ResultSet rs = stmt.executeQuery();
	try
	{
	while(rs.next())
	{
	User userObj = new User();
	userObj.setId(rs.getInt("idusers"));
	userObj.setUsername(rs.getString("username"));
	userObj.setPassword(rs.getString("password"));
	userObj.setName(rs.getString("name"));
	userObj.setEmail(rs.getString("email"));
	usersList.add(userObj);
	}
	} catch (SQLException e)
	{
	e.printStackTrace();
	}
	return usersList;
	 
	}

}
