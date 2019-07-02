<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 리스트</title>
</head>
<body>
	<table border="1" style="text-align: center;">
		<thead>
			<tr>
				<th>부서 아이디</th>
				<th>부서명</th>
				<th>매니저 아이디</th>
				<th>지역 아이디</th>
				<th>사원 리스트</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="dept" items="${depts }">
			<tr>
				<td>${dept.deptId }</td>
				<td>${dept.deptName }</td>
				<td>${dept.managerId }</td>
				<td>${dept.locationId }</td>
				<td><a href="../employee/employees.do?deptid=${dept.deptId }">GO</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<hr/>
	<div>
		<a href="../employee/form.do">사원 정보 등록하기</a>
	</div>
</body>
</html>