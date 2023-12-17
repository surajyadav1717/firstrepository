package com.studentproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentproject.pojo.User;
import com.studentproject.util.DBConnect;

public class UserDao {


	Connection con=DBConnect.getConnect();


	public boolean adduser(User user) {

		String sql ="insert into user (name , email , password) values (?,?,?)";

		try {

			PreparedStatement ps=con.prepareStatement(sql);

			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3,user.getPassword());

			int i =ps.executeUpdate();

			if (i>0) {
				return true;

			}
		}catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}	

	public boolean updateUser(User user) {

		String sql ="update user set name=? , email=?, password=? where id =?";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getId());

			int i =ps.executeUpdate();

			if(i>0) {
				return true;
			}


		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(int id) {

		String sql = "delete from user where id=?";

		try {

			PreparedStatement ps=con.prepareStatement(sql);

			ps.setInt(1,id );

			int i=ps.executeUpdate();

			if (i>0) {

				return true;
			}


		}catch (Exception e) {
			e.printStackTrace();

		}

		return false;

	}
	public List<User> getAllUsersList(){

		List<User> ul=new ArrayList<User>();

		String sql ="select * from user";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();

			while(rs.next()) {

				User u = new User();

				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				ul.add(u);
			}



		}catch (Exception e) {
			e.printStackTrace();

		}

		return ul;		
	}

	public User getUserByid(int id){


		User u = new User();
		String sql ="select * from user where id =?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs=ps.executeQuery();

			while(rs.next()) {


				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
			}

		}catch (Exception e) {
			e.printStackTrace();

		}

		return u;

	}
	
	
	public User loginUser(String email , String password){

		User u = null;
		String sql ="select * from user where email=? and password =? ";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
		
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {

			
				u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
			}

		}catch (Exception e) {
			e.printStackTrace();

		}

		return u;

	}
}
