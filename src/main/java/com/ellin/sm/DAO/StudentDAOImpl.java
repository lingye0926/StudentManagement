package com.ellin.sm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ellin.sm.api.Student;
import com.ellin.sm.rowMapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> loadStudents() {
		
		String sql = "SELECT * FROM STUDENTS";
		List<Student> theListOfStudent = jdbcTemplate.query(sql,new StudentRowMapper());

		return theListOfStudent;
	}

	@Override
	public void saveStudent(Student student) {
		
		String name = student.getName();
		Long mobile = student.getMobile();
		String country = student.getCountry();
		
		Object[] sqlParameters = {name,mobile,country};
		
		String sql = "insert into students (name,mobile,country) values(?,?,?)";
		jdbcTemplate.update(sql, sqlParameters);
		System.out.println("1 record saved...");
		
	}

	@Override
	public Student getStudent(int id) {
		
		String sql = "SELECT * FROM STUDENTS WHERE ID = ?";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		String sql = "UPDATE STUDENTS SET name =?,mobile =?,country =? WHERE id =? ";
		jdbcTemplate.update(sql, student.getName(),student.getMobile(),student.getCountry(),student.getId());
		
	}

	@Override
	public void deleteStudent(int id) {
		String sql = "DELETE FROM STUDENTS WHERE id = ?";
		int isUpdated = jdbcTemplate.update(sql, id);
		
	}

}
