package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.util.DBUtil;

public class UserDaoImpl implements UserDao 
{

	@Override
	public boolean isValidUser(String regdno, String password) {
		String 	query="SELECT * FROM student WHERE regdno=? AND password=?";
		try(Connection connection =DBUtil.getConnection();
		   PreparedStatement preparedstatement =connection.prepareStatement(query))
		{
			preparedstatement.setString(1,regdno);
			preparedstatement.setString(2,password);
			ResultSet resultSet=preparedstatement.executeQuery();
			System.out.println("Query run ");
			return resultSet.next();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addUser(User user) 
	{
		String 	query="INSERT INTO student (regdno,phone_number,name,mail,password) VALUES(? ,? ,? ,? ,?)";
		try(Connection connection =DBUtil.getConnection();
				   PreparedStatement preparedstatement =connection.prepareStatement(query))
				{
					preparedstatement.setString(1,user.getRegdno());
					preparedstatement.setString(2,user.getPhone());
					preparedstatement.setString(3,user.getName());
					preparedstatement.setString(4,user.getEmail());
					preparedstatement.setString(5,user.getPassword());
					
					int rows=preparedstatement.executeUpdate();
					System.out.println("Successfully created");
					return rows>0;	
             	}
		        catch(SQLException e)
		        {
			         e.printStackTrace();
			         return false;
		         }
		
	}

	
	// try
	@Override
	public boolean isValidUser1(String teacherid, String password) 
	{
		String 	query="SELECT * FROM teacher WHERE teacherid=? AND password=?";
		try(Connection connection =DBUtil.getConnection();
		   PreparedStatement preparedstatement =connection.prepareStatement(query))
		{
			preparedstatement.setString(1,teacherid);
			preparedstatement.setString(2,password);
			ResultSet resultSet=preparedstatement.executeQuery();
			System.out.println("Query run ");
			return resultSet.next();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	
	
	
	// try
	
	
	@Override
	public boolean addUser(User1 user1)
	{
		String 	query="INSERT INTO teacher (teacherid,phone,name,email,password) VALUES(? ,? ,? ,? ,?)";
		try(Connection connection =DBUtil.getConnection();
				   PreparedStatement preparedstatement =connection.prepareStatement(query))
				{
					preparedstatement.setString(1,user1.getTeacherid());
					preparedstatement.setString(2,user1.getPhone());
					preparedstatement.setString(3,user1.getName());
					preparedstatement.setString(4,user1.getEmail());
					preparedstatement.setString(5,user1.getPassword());
					
					int rows=preparedstatement.executeUpdate();
					System.out.println("Successfully created");
					return rows>0;	
             	}
		        catch(SQLException e)
		        {
			         e.printStackTrace();
			         return false;
		         }
	}
	
	
}
	
