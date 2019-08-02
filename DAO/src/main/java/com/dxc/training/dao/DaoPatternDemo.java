package com.dxc.training.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.dxc.training.factory.SQLHelperFactory;

public class DaoPatternDemo {
	   public static void main(String[] args) {
		try {	   
			Connection connection = SQLHelperFactory.connect();
	      StudentDao studentDao = new StudentDaoImpl();
	      //
	      //Create table  Student
	      studentDao.createTableStudent(connection);
	      
	      //Insert student 
	      studentDao.insertStudent(new Student(1,"Michael"), connection);
	      studentDao.insertStudent(new Student(2,"Richard"), connection);
	      studentDao.insertStudent(new Student(3,"Jonhson"), connection);
	      studentDao.insertStudent(new Student(4,"Susan"), connection);

	      //update student
	      Student student = new Student(3, "Smith");
	      studentDao.updateStudent(student, connection);
	      
	      //delete student
	      studentDao.deleteStudent(2, connection);

	      //get the student
	      studentDao.getStudent(1, connection);
	      
	      //get all students
	      studentDao.getAllStudents(connection);
	      
	      //delete student 
	     // studentDao.deleteStudents(connection);
	      
	      //Drop table student

	      studentDao.dropTableStudent(connection);
	  	   connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }

	}