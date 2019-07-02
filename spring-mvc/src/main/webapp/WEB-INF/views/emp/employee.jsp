<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 상세 정보</title>
</head>
<body>
	<h1>${param.empid }번 사원의 상세 정보</h1>

	<table border="1" style="text-align: center;">
		<thead>
			<tr>
				<th>사원 아이디</th>
				<th>사원명</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>고용일</th>
				<th>직종 아이디</th>
				<th>급여</th>
				<th>커미션</th>
				<th>매니저 아이디</th>
				<th>부서 아이디</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${emp.empId }</td>
				<td>${emp.firstName } ${emp.lastName }</td>
				<td>${emp.email }</td>
				<td>${emp.phone }</td>
				<td>${emp.hireDate }</td>
				<td>${emp.jobId }</td>
				<td>${emp.salary }</td>
				<td>${emp.commission }</td>
				<td>${emp.managerId }</td>
				<td>${emp.deptId }</td>
			</tr>
		</tbody>
	</table>
	<hr/>
	<div>
		<button><a href="employees.do?deptid=${emp.deptId }">사원 목록으로 돌아가기</a></button>
	</div>
</body>
</html>