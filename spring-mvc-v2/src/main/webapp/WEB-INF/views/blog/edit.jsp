<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%pageContext.setAttribute("CRLF", "\r\n");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그 컨텐츠 수정</title>
</head>
<body>
	<form method="post">
	<input type="hidden"name ="_method" value = "put"/>
		<p>글번호 : ${blogCont.BLG_CONT_SEQ}</p>
		<p>
			컨첸트 제목 : 
			<input type="text"name ="title" style="width:80%" value="${blogCont.TITLE}"/>
		</p>
		<p>
			본문
		</p>
		<p>
			<textarea rows="10" name="contBdy" style="width:100%">${blogCont.CONT_BDY}</textarea>
		</p>
		<p>입력일  :<fmt:formatDate value="${blogCont.INSERT_DT}" pattern='yyyy.mm.dd HH:mm:ss'/></p>
		<p>
			 <input type="submit" name="create" value ="블로그 컨텐츠 수정"/>
		</p>
	</form>
</body>
</html>