<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%BookVo m=(BookVo)request.getAttribute("m"); %>
	<form
		action="<%=request.getContextPath() %>/control?pno=<%=m.getNum()%>"
		method="post">
		
		도서이름 : <input type ="text" name="title" value="<%=m.getTitle()%>"><br>
		저   자 : <input type ="text" name="author" value="<%=m.getAuthor()%>"><br>
		출 판 사 : <input type ="text" name="publisher" value="<%=m.getPublisher()%>"><br>
		상세정보 : <textArea cols="45" rows="15" name="content"><%=m.getContent() %></textArea>
		
		
		</form>
</body>
</html>