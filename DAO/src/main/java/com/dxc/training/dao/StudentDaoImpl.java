package com.dxc.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
	
   //list is working as a database
   List<Student> students;

   public void deleteStudent(int id, Connection conn) {
		String tableSQL = "DELETE student where id = ?";


		try {
			PreparedStatement preparedStatement = conn.prepareStatement(tableSQL);

			preparedStatement.setInt(1, id);
			// execute insert SQL statement
			preparedStatement.executeUpdate();

			System.out.println("Record student with id = " + String.valueOf(id) + " is deleted!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}  


   }
   public List<Student> getAllStudents(Connection conn) {
	   List<Student> students = new ArrayList<Student>();
	   String selectSQL = "SELECT id, name FROM student order by id";

	   try {
		   PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
		   ResultSet rs = preparedStatement.executeQuery();
		   while (rs.next()) {
		   	String username = rs.getString("name");
		   	int id = rs.getInt("id");
			Student student = new Student(id,username); 
			students.add(student);
		   }
		   for(Student student : students)
			System.out.println("Record id = " + String.valueOf(student.getId()) + ", name = " + student.getName());
			
	   }
	   catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	   }
	   return students;
   }
	   

   public Student getStudent(int id, Connection conn) {
	   Student student = null;
	   String selectSQL = "SELECT id, name FROM student WHERE id = ?";

	   try {
		   PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
		   preparedStatement.setInt(1, id);
		   ResultSet rs = preparedStatement.executeQuery();
		   if (rs.next()) {
		   	String username = rs.getString("name");
			   student = new Student(id,username);   	
		   }
			System.out.println("Record id = " + String.valueOf(id) + ", name = " + student.getName());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

      return student;
   }

   public void updateStudent(Student student,Connection conn) {
		String tableSQL = "UPDATE student set name = ? where id = ?";


		try {
			PreparedStatement preparedStatement = conn.prepareStatement(tableSQL);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getId());
			// execute insert SQL statement
			preparedStatement.executeUpdate();

			System.out.println("Record id = " + String.valueOf(student.getId()) + ", name = " + student.getName() + " is updated into Student table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}  
   }
	public void insertStudent(Student student, Connection conn) {
		String tableSQL = "INSERT INTO student"
				+ "(id, name) VALUES"
				+ "(?,?)";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(tableSQL);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record id = " + String.valueOf(student.getId()) + ", name = " + student.getName() + " is inserted into Student table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
		
	}
	public void deleteStudents(Connection conn) {
		String tableSQL = "DELETE student";


		try {
			PreparedStatement preparedStatement = conn.prepareStatement(tableSQL);

			// execute insert SQL statement
			preparedStatement.executeUpdate();

			System.out.println("All Record of students are deleted!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}  
		
	}
	public void createTableStudent(Connection conn) {
		String tableSQL = "CREATE table student (id int, name varchar(100))";


		try {
			PreparedStatement preparedStatement = conn.prepareStatement(tableSQL);

			// execute insert SQL statement
			preparedStatement.executeUpdate();
			System.out.println("Table students are created!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
		
	}
	public void dropTableStudent(Connection conn) {
		String tableSQL = "Drop table student";


		try {
			PreparedStatement preparedStatement = conn.prepareStatement(tableSQL);

			// execute insert SQL statement
			preparedStatement.executeUpdate();

			System.out.println("Table students are dropped!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
		
	}
}
