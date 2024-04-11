<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명부작성</title>
</head>
<body>


<form id="create" method='post'>
	 <label for="phone_number">전화번호:</label><br>
        <input type="text" id="phone_number" name="phone_number"><br><br>

        <label>성별:</label><br>
        <input type="radio" id="male" name="gender" value="male">
        <label for="male">남성</label><br>
        <input type="radio" id="female" name="gender" value="female">
        <label for="female">여성</label><br><br>

        <label for="name">이름:</label><br>
        <input type="text" id="name" name="name"><br><br>

        <label for="resident_id">주민등록번호:</label><br>
        <input type="text" id="resident_id" name="resident_id"><br><br>

        <label for="address">주소:</label><br>
        <input type="text" id="address" name="address"><br><br>

        <input type="submit" value="확인">
</form>
	
	

	
	
	
	
</body>
</html>