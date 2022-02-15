<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=request.getContextPath() %>/book/insert.jsp">상품등록</a>
	<a href="<%=request.getContextPath() %>/control?type=list">전체상품출력</a>
	<a href="<%=request.getContextPath() %>/book/find.jsp">검색 및 수정</a>
</body>

</html>