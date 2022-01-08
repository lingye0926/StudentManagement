<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">

		<h1>Add Student</h1>
		<!-- create a html form where the user can enter data  -->

		<form:form action="save-student" modelAttribute="student" method="POST">
			<form:hidden path="id"/>
			<label>Name : </label>
			<form:input path="name" />
			<br>
			<label>Mobile : </label>
			<form:input path="mobile" />
			<br>
			<label>Country : </label>
			<form:input path="country" />
			<br>
			<input type="submit" value="submit">

		</form:form>

	</div>
</body>
</html>