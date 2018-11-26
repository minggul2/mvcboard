<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "../css/board.css">
</head>
<body>
	<table border = "0" cellpadding = "5" cellspacing = "0" frame = "hsides" rules ="rows" color = "red" align  ="center" id = "view_table">
		<tr>
			<td width = "450" colspan = "3"><h3>${boardDTO.subject}</h3></td>
		</tr>
		
		<tr>
			<td width = "150" align = "center">글번호 : ${boardDTO.seq}</td>
			<td width = "150" align = "center">작성자 : ${boardDTO.id}</td>
			<td width = "150" align = "center">조회수 : ${boardDTO.hit}</td>
		</tr>
		
		<tr>
			<td height = "250" colspan = "3" valign = "top"><pre>${boardDTO.content}</pre></td>
		</tr>
	</table>
	<div id = "comment_write" align = "center">
		<form id = "comment_form" method = "post" action = "commentWrite.do">
			<input type = "hidden" value = "${boardDTO.seq}" id = "seq" name = "seq">
			<input type = "hidden" value = "${pg}" id = "pg" name = "pg" />
			<textarea cols = "100" rows = "2" name = "content"></textarea> <input type = "button" id = "comment_write_button" value = "댓글달기"/>
		</form>
	</div>
	
	<br>
	<c:forEach var = "list" items = "${comment_list}">
		<div id = "comment_div" style = "background-color : magenta; height : 40px; weight : 100%;">
			${list.id} ${list.content} ${list.logtime}
		</div>
	</c:forEach>
	
	<div align = "center" id = "view_div">	
	<input type = "button" value = "목록" onclick = "location.href = 'boardList.do?pg=${pg}'">
	<input type = "button" value = "답글" onclick = "location.href = 'replyBoardWriteForm.do?seq=${boardDTO.seq}'">
	<c:if test="${id eq boardDTO.id}">
		<input type = "button" value = "글수정" id = "board_modify_button">
		<input type = "button" value = "글삭제">
	</c:if>
	</div>
	<script src = "http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src = "../js/board.js"></script>
</body>
</html>