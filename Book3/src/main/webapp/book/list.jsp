<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<BookVo> list = (ArrayList<BookVo>) request.getAttribute("data");
	%>
	<br>
	<table border=1>
		<tr>
			<th>num</th>
			<th>title</th>
			<th>author</th>
			<th>publisher</th>
			<th>contents</th>
		</tr>
		<%
		for (int i = 0; i < list.size(); i++) {
			BookVo x = list.get(i);
		%>
		<tr>
			<td><%=x.getNum()%></td>
			<td><%=x.getTitle()%></td>
			<td><%=x.getAuthor()%></td>
			<td><%=x.getPublisher()%></td>
			<td><%=x.getContent()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<form action="<%=request.getContextPath()%>/control" method="post">
		<input type="hidden" name="type" value="logout">
	</form>
</body>
</html>