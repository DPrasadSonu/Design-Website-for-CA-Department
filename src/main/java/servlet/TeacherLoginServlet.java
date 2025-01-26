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

/**
 * Servlet implementation class TeacherLoginServlet
 */
@WebServlet("/TeacherLoginServlet")
public class TeacherLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao=new UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teacherid=request.getParameter("teacherid");
		   String password=request.getParameter("password");
		   if(userDao.isValidUser1(teacherid,password))
		   {
	     	   HttpSession session=request.getSession();
	    	   session.setAttribute("Regd No is ",teacherid);
	    	   response.sendRedirect("teacherwelcome.html");
		   }
		   else
		   {
			   response.sendRedirect("TeacherLogin.jsp?error=1");
			   System.out.println("Error");
		   }
	}

}
