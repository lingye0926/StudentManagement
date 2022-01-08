package com.ellin.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ellin.sm.api.Student;
import com.ellin.sm.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/showStudent")
	public String showStudentList(Model model) {
		
		//call the dao method to get the data
		
		List<Student> studentList = studentService.loadStudents();
		
//		for(Student tempStudent :studentList) {
//			System.out.println(tempStudent);
//		}
		model.addAttribute("students",studentList);
		
		return "student-list";
	}
	
	@GetMapping("/showAddStudentPage")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "add-student";
		
	}
	

	@PostMapping("/save-student")
	public String saveStudent(Student student) {
		//write the logic to save the data(studentDTO) to the database
//		System.out.println(student);
		
		if(student.getId()!= null) {

			studentService.updateStudent(student);
		}else {
			//do a DAO call to save the students
			studentService.saveStudent(student);
		}

		return "redirect:/showStudent";
	}
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id,Model model) {
//		Student myStudent = new Student();
//		model.addAttribute("student",myStudent);
		
		//we should give the user object who clicked on the update button
		System.out.println("looking data for the student having id:"+ id);
		
		Student theStudent = studentService.getStudent(id);
//		System.out.println(theStudent);
		
		//setting the student information and attached to the model 
		model.addAttribute("student", theStudent);

		return "add-student";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id) {
		studentService.deleteStudent(id);
		return "redirect:/showStudent";
	}

}
