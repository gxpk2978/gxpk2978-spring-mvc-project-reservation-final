<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<title>명부</title>
</head>
<body>
<h1>
	해당 버튼을 누르면 각 화면으로 이동합니다. 
</h1>
<form id="searchForm" method="POST">
    <label for="resident_id">주민등록번호:</label><br>
    <input type="text" id="resident_id" name="resident_id"><br><br>

    <label for="name">이름:</label><br>
    <input type="text" id="name" name="name"><br><br>

    <button type="submit">조회하기</button>
</form>
<div>
<a href="/board/create"><button>등록하기</button></a>
</div>

<p>------------------------------ 여기는 명부 목록 보여주기--------------------------------</p>
</body>
</html>
