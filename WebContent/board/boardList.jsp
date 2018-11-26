<%@page import="board.bean.BoardPaging"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>

<link rel = "stylesheet" href = "../css/board.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align = "center" >
	<input type = "hidden" value = "${pg}" id = "pg"/>
	<table border = "0" cellpadding = "5" cellspacing = "0"  frame = "hsides" rules ="rows" id = "board_table">
		<tr>
			<th width = "100">글번호</th>
			<th width = "300">제목</th>
			<th width = "100">작성자</th>
			<th width = "100">작성일</th>
			<th width = "100">조회수</th>
		</tr>
		
		<c:if test = "${list != 'null' || list ne null}">

			<c:forEach var="boardDTO" items="${list}" varStatus = "i">
				<tr>
					<td class = "board">${boardDTO.seq}${boardDTO.lev}</td>
					<!-- 답글 밀어내기 -->
					<td class = "board">lev : ${boardDTO.lev}
					
						<c:forEach var = "lev" begin="0" end="${boardDTO.lev}">
							&emsp;RE:	
						</c:forEach>
					&nbsp;<a href = "#" id = "view_aTag">${boardDTO.subject}</a></td>
					<td class = "board">${boardDTO.id}</td>
					<td class = "board">${boardDTO.logtime}</td>
					<td class = "board">${boardDTO.hit}</td>
					<td>lev : ${boardDTO.lev}</td>
					<td>dddddddddddddd</td>
					
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<br><br>
	
	
	
</div>

<div align = "center">
<img style = "float : center; cursor: pointer;" src = "../image/aa.png" onclick = "location.href = '../main/index.jsp'">
<div style = "float : center; border : 1px red solid; width : 600px; text-align : center;" align = "center">${boardPaging.pagingHTML}</div>
</div>
<script src = "http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src ="../js/board.js">
	
</script>

</body>
</html>