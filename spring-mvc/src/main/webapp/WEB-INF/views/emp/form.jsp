<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 입력폼</title>
</head>
<body>
	<h1>신규 사원 등록하기</h1>
	
	<form method="post" action="add.do">
		<p>이름 : <input type="text" name="firstName"/></p>
		<p>성 : <input type="text" name="lastName"/></p>
		<p>이메일 : <input type="text" name="email"/></p>
		<p>전화번호 : <input type="text" name="phone"/></p>
		<p>
			직종 아이디
			<select name="jobId">
				<option value="">-- 선택하세요 --</option>
				<c:forEach var="jobId" items="${jobIds }">
					<option value="${jobId }">${jobId }</option>
				</c:forEach>
			</select>
		</p>
		<p>급여 : <input type="text" name="salary"/></p>
		<p>매니저 아이디(100 ~ 206) : <input type="text" name="managerId"/></p>
		<p>
			부서 아이디
			<select name="deptId">
				<option value="">-- 선택하세요 --</option>
				<c:forEach var="deptId" items="${deptIds }">
					<option value="${deptId }">${deptId }</option>
				</c:forEach>
			</select>
		</p>
		<button type="submit">등록하기</button>
	</form>
</body>
</html>