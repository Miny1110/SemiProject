<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복확인</title>

<script type="text/javascript" src="<%=cp%>/Data/style/js/customer.js"></script>

</head>
<body>
[${customerId }]은(는) ${msg}<br/>

<input type="button" value="${bnt_msg }" onclick="window.close();">
</body>
</html>