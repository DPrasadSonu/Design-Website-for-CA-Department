package com.company.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.User;
import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;

/**
 * Servlet implementation class StudentRegisterServlet
 */
@WebServlet("/StudentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao=new UserDaoImpl();
       
    public StudentRegisterServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		 String regdno=request.getParameter("regdno");
		 String phone_number=request.getParameter("phone_number");
		 String name=request.getParameter("name");
		 String email=request.getParameter("email");
		 String password=request.getParameter("password");
		 
		 User user=new User();
		 user.setRegdno(regdno);
		 user.setPhone(phone_number);
		 user.setName(name);
		 user.setEmail(email);
		 user.setPassword(password);
		 
		 if(userDao.addUser(user))
		 {
			 response.sendRedirect("StudentLog.jsp?registration=success");
		 }
		 else
		 {
			 response.sendRedirect("StudentReg.jsp?error=1");
			   System.out.println("Error");
		 }
		 
		 
		 
	}

}
