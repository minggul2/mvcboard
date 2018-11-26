<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
sdasdsadad
asdsadsW
	BoardDAO boardDAO = BoardDAO.asfeksjaefkls();
	boardDAO.boardModify(subject, cawjdlkawjd, seq);
%>

<html>
	<script>
		window.onload=function(){
			alert("수정 완료");
			location.href="boardList.jsp?pg="+<%=pg%>;
			asdsadasd;
		}
	</script>	
</html>
