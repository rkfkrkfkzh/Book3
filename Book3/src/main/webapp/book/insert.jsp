<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkInsert(r) {
		if (r.title.value == "") {
			alert("상품명을 입력하세요");
			r.title.focus();
			return;
		} else if (r.author.value == "") {
			alert("저자를 입력하세요");
			r.author.focus();
			return;
		} else if (r.publisher.value == "") {
			alert("출판사를 입력하세요");
			r.publicher.focus();
			return;
		} else if (r.content.value == "") {
			alert("상세정보를 입력하세요");
			r.content.focus();
			return;
		}
		r.submit();
	}
</script>
</head>
<body>

	<form name="x"
		action="<%=request.getContextPath()%>/control?type=insert"
		method="post">
		<table>
			<tr>
				<td>도서명 : <input type="text" name="title"><br>
				<br></td>
			</tr>
			<tr>
				<td>저자 : <input type="text" name="author"><br>
				<br></td>
			</tr>
			<tr>
				<td>출판사 : <input type="text" name="publisher"><br>
				<br></td>
			</tr>
			<tr>
				<td>상세정보 : <textArea cols="45" rows="15" name="content"></textArea></td>
			</tr>

		</table>
		<input type="button" onClick="checkInsert(this.form)" value="상품입력">

	</form>
</body>
</html>