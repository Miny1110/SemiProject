<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=cp%>/Data/style/js/itemCreated.js"></script>

</head>
<body>

<form name="myForm" method="post" enctype="multipart/form-data">
<table>
<tr>
	<td>상품명</td>
	<td><input type="text" name="itemName"></td>
</tr>

<tr>
	<td>가격</td>
	<td><input type="text" name="itemPrice"></td>
</tr>

<tr>
	<td>할인</td>
	<td><input type="text" name="itemDiscount"></td>
</tr>

<tr>
	<td>카테고리</td>
	<td>
		<select name="itemType">
			<option value="과일">과일</option>
			<option value="빵">빵</option>
			<option value="정육">정육</option>
		</select>
	</td>
</tr>

<tr>
	<td>내용</td>
	<td><textarea rows="10" cols="30" name="itemContent"></textarea></td>
</tr>

<tr>
	<td>이미지1</td>
	<td><input type="file" name="itemImage1">
</tr>
<tr>
	<td>이미지2</td>
	<td><input type="file" name="itemImage2">
</tr>
<tr>
	<td>이미지3</td>
	<td><input type="file" name="itemImage3">
</tr>
<tr>
	<td>이미지4</td>
	<td><input type="file" name="itemImage4">
</tr>

<tr>
	<td>재고</td>
	<td><input type="text" name="itemStock">
</tr>

<tr>
	<td><input type="button" value=" 등록하기 " onclick="sendIt();"></td>
</tr>

</table>
</form>
</body>
</html>