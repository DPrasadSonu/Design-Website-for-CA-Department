package com.company.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil
{
   private static final String URL="jdbc:mysql://localhost:3306/subrat";
   private static final String REGDNO="root";
   private static final String PASSWORD="Subrat@5802";
   static
   {
	   try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
	       }
	   catch(ClassNotFoundException e)
	   {
		   e.printStackTrace();
	   }
   }
   public static Connection getConnection() throws SQLException
   {
	   return DriverManager.getConnection(URL,REGDNO,PASSWORD);
   }
   
   // try
   
   static
   {
	   try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
	       }
	   catch(ClassNotFoundException e)
	   {
		   e.printStackTrace();
	   }
   }
   public static Connection getConnection1() throws SQLException
   {
	   return DriverManager.getConnection(URL,REGDNO,PASSWORD);
   }

   
}
