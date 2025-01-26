package com.company.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;

@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao=new UserDaoImpl();
       
    public StudentLoginServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	   String regdno=request.getParameter("regdno");
	   String password=request.getParameter("password");
	   if(userDao.isValidUser(regdno,password))
	   {
     	   HttpSession session=request.getSession();
    	   session.setAttribute("Regd No is ",regdno);
    	   response.sendRedirect("welcome.jsp");
	   }
	   else
	   {
		   response.sendRedirect("StudentLog.jsp?error=1");
		   System.out.println("Error");
	   }
	}

}
