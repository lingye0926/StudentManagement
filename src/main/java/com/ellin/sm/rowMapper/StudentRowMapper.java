package com.ellin.sm.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ellin.sm.api.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		

		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setName(rs.getNString("name"));
		student.setMobile(rs.getLong("mobile"));
		student.setCountry(rs.getNString("country"));
		
		
		return student;
	}

}
