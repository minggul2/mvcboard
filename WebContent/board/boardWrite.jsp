<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
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
	/*
		window.onload = function(){
			alert("글쓰기 성공");ㅣ
			location.href = 'boardList.jsp';
		}
	*/
	//		alert("작성하신글을 저장하였습니다");
		window.onload=function(){
			alert("글쓰기 성공");
			location.href="boardList.do?pg=1";
		}
	</script>
</body>
</html>