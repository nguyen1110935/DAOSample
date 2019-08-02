package com.dxc.training.dao;

import java.sql.Connection;
import java.util.List;

public interface StudentDao {
	   public List<Student> getAllStudents(Connection conn);
	   public Student getStudent(int rollNo, Connection conn);
	   public void insertStudent(Student student, Connection conn);
	   public void updateStudent(Student student, Connection conn);
	   public void deleteStudent(int id, Connection conn);
	   public void deleteStudents(Connection conn);
	   public void createTableStudent(Connection conn);
	   public void dropTableStudent(Connection conn); 
}
