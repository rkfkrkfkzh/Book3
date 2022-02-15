<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath() %>/control?type=update">
도서번호 : <input type="text" name="pno">
<input type="submit" value="전송">
</form>
<form method="post" action="<%=request.getContextPath() %>/control?type=delete">
삭제할 번호 : <input type="text" name="pno">
<input type="submit" value="전송">
</form>
</body>
</html>