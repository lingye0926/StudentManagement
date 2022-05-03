Build a webpage to display the students(db)
===========================
	a. Configure dispatcher servlet
	b. Create a configuration file
  1. create controller (StudentController)
  2. design a view(student-list.jsp)

DB conenction is using jdbctemplate
====================
  
get the data from database(get all the students)
====================
  	
  	a) Create a POJO or a domain class called:
  	
  	Student
  	->id
  	->name
  	->mobile
  	->country
  	
  	
  1. create a DAO called StudentDAO(I)
  			List<Student>   loadStudents();

	
	
insert a student record to the student table
===========================
	1. create a controller handler method to display [add-student.jsp]
	2. create a form(jsp)[add-student.jsp]
	
	controller ----> DAO ------> database
	
	
update a student record
=================
	a. Modify the student-list page and show a update link next to each student
	
	1. create a controller handler method for update
		/updateStudent
		
	2. show the user the add-student form
		[add-student.jsp]
