package com.company.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.User;
import com.company.dao.User1;
import com.company.dao.UserDao;
import com.company.dao.UserDaoImpl;

/**
 * Servlet implementation class TeacherRegisterServlet
 */
@WebServlet("/TeacherRegisterServlet")
public class TeacherRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao=new UserDaoImpl();
       
    public TeacherRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 String teacherid=request.getParameter("teacherid");
		 String phone=request.getParameter("phone");
		 String name=request.getParameter("name");
		 String email=request.getParameter("email");
		 String password=request.getParameter("password");
		 
		 User1 user1=new User1();
		 user1.setTeacherid(teacherid);
		 user1.setPhone(phone);
		 user1.setName(name);
		 user1.setEmail(email);
		 user1.setPassword(password);
		 
		 if(userDao.addUser(user1))
		 {
			 response.sendRedirect("TeacherLogin.jsp?registration=success");
		 }
		 else
		 {
			 response.sendRedirect("TeacherRegister.jsp?error=1");
			   System.out.println("Error");
		 }
		 
	}

}
