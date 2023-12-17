package com.studentproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentproject.pojo.Student;
import com.studentproject.pojo.User;
import com.studentproject.util.DBConnect;

public class Studentdao {																																										

	Connection con =DBConnect.getConnect();

	public boolean addStudent(Student student) {

		String sql ="insert into student (name,rollno,grade,college ) values( ?,?,?,?)";

		try {

			PreparedStatement ps=con.prepareStatement(sql);


			ps.setString(1, student.getName());
			ps.setString(2, student.getRollno());
			ps.setString(3, student.getGrade());
			ps.setString(4, student.getCollege());
			int i =ps.executeUpdate();

			if(i>0) {

				return true;
			}


		}catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	public boolean updateStudent(Student student) {

		Connection con =DBConnect.getConnect();

		String sql="update  student set name=? ,rollno=? ,grade=? ,college=? where id =?";

		try {

			PreparedStatement ps=con.prepareStatement(sql);

			ps.setString(1, student.getName());
			ps.setString(2, student.getRollno());
			ps.setString(3, student.getGrade());
			ps.setString(4, student.getCollege());
			ps.setInt(5, student.getId());

			int i =ps.executeUpdate();

			if(i>0) {

				return true;
			}

		}catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteStudent(int id) {

		Connection con=DBConnect.getConnect();

		String sql ="delete from student where id =?";

		try {

			PreparedStatement ps=con.prepareStatement(sql);

			ps.setInt(1,id);

			int i =ps.executeUpdate();

			if (i>0) {
				return true;
			}

		}catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	public  List<Student> getAllStudentList(){


		List<Student> sl=new ArrayList<Student>();

		String sql ="select * from student";

		try {

			PreparedStatement ps =con.prepareStatement(sql);

			ResultSet rs =ps.executeQuery();

			while(rs.next()) {

				Student s = new Student();

				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setRollno(rs.getString("rollno"));
				s.setGrade(rs.getString("grade"));
				s.setCollege(rs.getString("college"));
				
				
				sl.add(s);

			}

		}catch (Exception e) {

			e.printStackTrace();
		}

		return sl;

	}
	
	public Student getStudentByid(int id){


		Student s =new Student();
		String sql ="select * from student where id =?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs=ps.executeQuery();

			while(rs.next()) {


				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setRollno(rs.getString("rollno"));
				s.setGrade(rs.getString("grade"));
				s.setCollege(rs.getString("college"));
			}

		}catch (Exception e) {
			e.printStackTrace();

		}

		return s;

	}
}
