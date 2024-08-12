package com.techpalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
	public void creating() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle", "root", "Jyo@912001");
			Statement s=con.createStatement();
			s.execute("create table student(sno int primary key auto_increment,sname varchar(40),sub varchar(40),email varchar(40))");
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insert(String sname,String sub,String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle", "root", "Jyo@912001");
			String query="insert into student(sname,sub,email) values(?,?,?)";
			PreparedStatement s=con.prepareStatement(query);
			s.setString(1, sname);
			s.setString(2, sub);
			s.setString(3, email);
			s.executeUpdate();
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(int sno,String email,String sub) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle", "root", "Jyo@912001");
			String query="update student set sub=?,email=? where sno=?";
			PreparedStatement s=con.prepareStatement(query);
			s.setString(1, sub);
			s.setString(2, email);
			s.setInt(3, sno);
			s.executeUpdate();
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(int sno) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle", "root", "Jyo@912001");
			String query="delete from student where sno=?";
			PreparedStatement s=con.prepareStatement(query);
			s.setInt(1, sno);
			s.executeUpdate();
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void read() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle", "root", "Jyo@912001");
			String query="select * from student";
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery(query);
			while(r.next()==true) {
				System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println(r.getString(3));
				System.out.println(r.getString(4));
			}
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Student s=new Student();
//		s.creating();
//		s.insert("hari", "java", "hari@gmail.com");
//		s.insert("ravi", "python", "ravi@gmail.com");
//		s.insert("ram", "data science", "ram@gmail.com");
//		s.read();
//		s.update(1, "har@gmail", "python");
		s.delete(1);
	}

}
