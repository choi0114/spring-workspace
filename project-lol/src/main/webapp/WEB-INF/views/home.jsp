<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>롤 전적 검색 - oop.gg</title>
</head>
<body>
	<h1>롤 전적 검색</h1>
	
	<input type="text" name="summonorName" placeholder="소환사명을 입력해 주세요."/>
	<button>검색</button>
	
	<script type="text/javascript">
		$('button').click(function() {
			location.href="detail.lol";
		});
	</script>
</body>
</html>