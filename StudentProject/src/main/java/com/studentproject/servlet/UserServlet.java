package com.studentproject.servlet;

import java.io.IOException;
import java.util.List;

import com.studentproject.dao.UserDao;
import com.studentproject.pojo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	User user= new User();

	UserDao userDao= new UserDao();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();


		String action =request.getParameter("action");

		if(action!=null &&action.equals("delete")) {

			int id =Integer.parseInt(request.getParameter("id"));
			boolean b =userDao.deleteUser(id);

			if (b) {

				response.sendRedirect("UserServlet");
			}else {

				response.sendRedirect("error.jsp");
			}
		}

		else if(action!=null && action.equals("edit")) {

			int id =Integer.parseInt(request.getParameter("id"));

			User user=userDao.getUserByid(id);

			session.setAttribute("user", user);

			response.sendRedirect("updateuser.jsp");
		}
		else {
			List<User>userList=userDao.getAllUsersList();
			session.setAttribute("userList", userList);

			response.sendRedirect("userlist.jsp");
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action =request.getParameter("action");

		String name =request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");

		user.setName(name);user.setEmail(email);user.setPassword(password);

		if(action!=null && action.equals("adduser")) {

			boolean b =userDao.adduser(user);

			if (b) {
				response.sendRedirect("index.jsp");

			}else {

				response.sendRedirect("adduser.jsp");
			}
		}

		else if(action!=null && action.equals("updateuser")) {

			int id =Integer.parseInt(request.getParameter("id"));

			user.setId(id);

			boolean b =userDao.updateUser(user);

			if(b) {

				response.sendRedirect("UserServlet");
			}

			else {

				response.sendRedirect("error.jsp");
			}
		}
		else {

			response.sendRedirect("error.jsp");
		}

	}
}