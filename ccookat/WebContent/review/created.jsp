<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=cp%>/review/css"/>
<title>Insert title here</title>
</head>
<body>

					<div id="bbsCreated">
										<div class="bbsCreated_bottomLine"><dl>
									<b>작성자//아이디 로그인하면 그대로 들고오게하기</b>
									<br/><br/>
							
			<div class="bbsCreated_bottomLine">
			<dl>
				<dt>제목</dt>
				<dd>
					<input type="text" name="reviewTitle" size="50" 
					maxlength="50" class="boxTF"/>
				</dd>
			</dl>		
		</div>
		
		<div class="">
		<dl>
				<dt>내용</dt>
				<dd>
					<input type="text" name="reviewContent" size="50" 
					maxlength="150" class="boxTF"/>
				</dd>
			</dl>		
		</div>
		<td align="right"> 
<input type="button" value="파일 업로드"/>
</td>
<div id="bbsCreated_footer">
			<input type="button" value=" 등록하기 " class="btn2"
			onclick="sendIt();"/>
			<input type="reset" value=" 다시입력 " class="btn2"
					onclick="document.myForm.name.focus();"/>
			</div>

		
			
			</dl>		
		</div>
</body>
</html>