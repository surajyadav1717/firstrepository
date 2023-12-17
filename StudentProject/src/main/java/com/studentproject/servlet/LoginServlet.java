package com.studentproject.servlet;

import java.io.IOException;

import com.studentproject.dao.UserDao;
import com.studentproject.pojo.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao userDao = new UserDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session=request.getSession();

		session.invalidate();
		response.sendRedirect("index.jsp");



	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session=request.getSession();


		String UserType=request.getParameter("userType");

		String email=request.getParameter("email");

		String password =request.getParameter("password");


		if(UserType!=null && UserType.equals("admin")) {
			
			if(email!=null && password!=null &&email.equals("admin@gmail.com") && password.equals("admin123")){



			session.setAttribute("admin", "admin");

			response.sendRedirect("index.jsp");
		}

		else {

			String lmsg ="Invalid Username :'"+email+"'  &  Password:'"+password+"'";
			request.setAttribute("lmsg", lmsg);
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}
	
	else if(UserType!=null && UserType.equals("user")){

		User user =userDao.loginUser(email, password);

		if(user!=null) {
			session.setAttribute("user", user);

			response.sendRedirect("index.jsp");
		}
			else{

				String lmsg ="Invalid Username :'"+email+"'  &  Password:'"+password+"'";
				request.setAttribute("lmsg", lmsg);
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		}
	}
}
