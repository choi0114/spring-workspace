<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 리스트</title>
</head>
<body>
	<h1>${param.deptid }번 부서의 사원 리스트</h1>
	
	<table border="1" style="text-align: center;">
		<thead>
			<tr>
				<th>사원 아이디</th>
				<th>사원명</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="emp" items="${emps }">
			<tr>
				<td>${emp.empId }</td>
				<td><a href="employee.do?empid=${emp.empId }">${emp.firstName } ${emp.lastName }</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<hr/>
	<div>
		<button><a href="../department/depts.do">부서 목록으로 돌아가기</a></button>
	</div>
</body>
</html>