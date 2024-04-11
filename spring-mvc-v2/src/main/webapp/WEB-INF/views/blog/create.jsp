<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그 컨텐츠 작성</title>
</head>
<body>


<form method='post'>
	<p>
		컨텐츠 제목 : 
		<input type = 'text' name = 'title' style = 'width:80%'></input>
	</p>
	<p>
	본문
	</p>
	<p>
	<textarea rows='10' name = 'content_body' style = 'width:90%'></textarea>
	</p>
 	<p>
 		<input type = 'submit' name ="create" value= "블로그 컨텐츠 쓰기">
 	</p>
</form>
	
</body>
</html>