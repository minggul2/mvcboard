<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		window.onload = function(){
			alert("댓글등록 완료");
			location.href = "boardView.do?seq=${seq}&pg=${pg}";
		}
	</script>
</body>
</html>