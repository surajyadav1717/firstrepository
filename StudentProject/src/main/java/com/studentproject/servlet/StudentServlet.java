package com.studentproject.servlet;

import java.io.IOException;
import java.util.List;

import com.studentproject.dao.Studentdao;
import com.studentproject.pojo.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	Student student=new Student();

	Studentdao studentdao=new Studentdao();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();


		String action =request.getParameter("action");

		if(action!=null &&action.equals("delete")) {

			int id =Integer.parseInt(request.getParameter("id"));
			boolean b =studentdao.deleteStudent(id);

			if (b) {

				response.sendRedirect("StudentServlet");
			}else {

				response.sendRedirect("error.jsp");
			}
		}else if(action!=null && action.equals("edit")) {

			int id =Integer.parseInt(request.getParameter("id"));

			Student student =studentdao.getStudentByid(id);
			
			session.setAttribute("student", student);
			
			response.sendRedirect("updatestudent.jsp");

		}

		else {
			List<Student>studentList=studentdao.getAllStudentList();
			session.setAttribute("studentList", studentList);
			response.sendRedirect("studentlist.jsp");
		}	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");


		String name=request.getParameter("name");
		
		String rollno=request.getParameter("rollno");
		
		String grade=request.getParameter("grade");

		String college=request.getParameter("college");


		student.setName(name); student.setCollege(college);
		
		student.setGrade(grade); student.setRollno(rollno);
		


		if (action!=null && action.equals("addstudent")){

			boolean b=studentdao.addStudent(student);

			if(b){

				response.sendRedirect("index.jsp");


			} 
			else { 
				response.sendRedirect("addstudent.jsp"); 

			}

		}

		else if(action!=null && action.equals("updatestudent")) {

			int id =Integer.parseInt(request.getParameter("id"));

			student.setId(id);


			boolean b=studentdao.updateStudent(student);

			if(b) {

				response.sendRedirect("StudentServlet");
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


