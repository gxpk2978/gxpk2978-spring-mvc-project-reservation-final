<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%pageContext.setAttribute("CRLF", "\r\n");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그 컨텐츠 쓰기</title>
</head>
<body>

	<p>글번호 : ${blogCont.BLG_CONT_SEQ}</p>
	<p>제목 : ${blogCont.TITLE}</p>
	<hr />
	<div>
		${fn:replace(blogCont.CONT_BDY, CRLF, '<br />')} 
	</div>
	<hr/>
	
	<p>입력일  :<fmt:formatDate value="${blogCont.INSERT_DT}" pattern='yyyy.mm.dd HH:mm:ss' />

	<div>
		<form method="post" action="/delete">
			<input type = "hidden" name= "_method" value="delete" />
			<input type = "hidden" name= "blogContSeq" value=" ${blogCont.BLG_CONT_SEQ}"/>
			<input type = "submit" name= "delete_button" value="삭제"/>
		</form>
	</div>
</body>
</html>