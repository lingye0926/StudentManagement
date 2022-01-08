<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="FALSE"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
	<h1 align="center">Student Management</h1>

	<div align="center">

		<form action="showAddStudentPage">
			<input type="submit" value="ADD">
		</form>


		<table class="table table-dark table-striped">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Mobile</th>
				<th scope="col">Country</th>
				<th colspan="2">Operation</th>
			</tr>

			<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.mobile}</td>
					<td>${student.country}</td>
					<td><a href="updateStudent?userId=${student.id}">Update</a></td>
					<td><a href="deleteStudent?userId=${student.id}"onclick="if(!(confirm('Are you sure to delete this item?'))) return false">Delete</a></td>
				</tr>

			</c:forEach>

		</table>
	</div>
</body>
</html>