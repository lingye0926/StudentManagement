package com.ellin.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ellin.sm.DAO.StudentDAO;
import com.ellin.sm.api.Student;

@Repository
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentDAO studentDAO;
	
	
	@Override
	public List<Student> loadStudents() {
		List<Student> studentList = studentDAO.loadStudents();
		return studentList;
	}

	@Override
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);
		
	}

	@Override
	public Student getStudent(int id) {
		Student student = studentDAO.getStudent(id);
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
		
	}

	@Override
	public void deleteStudent(int id) {
		studentDAO.deleteStudent(id);
		
	}

}
