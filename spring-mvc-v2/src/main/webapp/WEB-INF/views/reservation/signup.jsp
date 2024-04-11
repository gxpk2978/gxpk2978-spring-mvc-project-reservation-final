<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%pageContext.setAttribute("CRLF", "\r\n");%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>수정</title>
    <style>
        /* 전체 body 스타일 */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
        }

        /* 폼 스타일 */
        #signupForm {
            max-width: 300px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        /* 라벨 스타일 */
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        /* 입력 필드 스타일 */
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: calc(100% - 12px);
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        /* 확인 버튼 스타일 */
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            background-color: #007bff;
            color: #fff;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
        }

        /* 확인 버튼 호버 효과 */
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        header {
            
            padding: 20px 0; /* 위아래 padding 설정 */
        }

        /* Home 버튼 스타일 */
        .home-button {
            color: #333; /* 글자색 설정 */
            font-weight: bold; /* 굵은 글자 설정 */
            text-decoration: none; /* 밑줄 제거 */
            padding: 10px 20px; /* 좌우 padding 설정 */
            border: 2px solid #333; /* 테두리 설정 */
            border-radius: 5px; /* 테두리 둥글게 설정 */
        }

        /* Home 버튼에 호버 효과 추가 */
        .home-button:hover {
            background-color: #333; /* 호버 시 배경색 변경 */
            color: #fff; /* 호버 시 글자색 변경 */
        }
        
    </style>
</head>

<body>	
    <header>
        <a href="#" class="home-button">Home</a>
    </header>
<form id="signupForm" onsubmit="submitForm(event)">
    <!-- 고객ID 입력란 추가 -->
    <label for="customer_id">고객ID (CustomerID):</label><br>
    <input type="text" id="customer_id" name="customer_id"><br><br>

    <!-- 비밀번호 입력란 -->
    <label for="password">비밀번호 (PassWord):</label><br>
    <input type="password" id="password" name="password"><br><br>

    <!-- 이름 입력란 -->
    <label for="name">이름 (Name):</label><br>
    <input type="text" id="name" name="name"><br><br>

    <!-- 전화번호 입력란 -->
    <label for="phone_number">전화번호 (Phone):</label><br>
    <input type="text" id="phone_number" name="phone_number"><br><br>

    <!-- 이메일 입력란 -->
    <label for="email">이메일 (Email):</label><br>
    <input type="email" id="email" name="email"><br><br>
    <input type="submit" value="확인">
</form>
       
       <button onclick="test()" type="button">TEST</button>
       
       
       
 <script>
function submitForm(event) {
    event.preventDefault(); // 폼의 기본 동작을 막음

    // 폼 데이터를 JavaScript 객체로 변환
    var formData = {
        customer_id: document.getElementById("customer_id").value,
        password: document.getElementById("password").value,
        name: document.getElementById("name").value,
        phone_number: document.getElementById("phone_number").value,
        email: document.getElementById("email").value
    };

    // JavaScript 객체를 JSON 문자열로 변환
    var jsonData = JSON.stringify(formData);

    // XMLHttpRequest 객체 생성
    var xhr = new XMLHttpRequest();

    // 요청 설정
    xhr.open("POST", "/reservation/signup");
    xhr.setRequestHeader("Content-Type", "application/json");

    // 응답 처리
    xhr.onload = function() {
        if (xhr.status == 200) {
            var data = JSON.parse(xhr.responseText);
            console.log(data)
            if (data.suc === "true") {
                alert("회원가입이 완료되었습니다.");
                window.location.href = "/reservation/reservation/" + data.customer_id;

            } else {
                alert("회원가입에 실패하였습니다.");
                window.location.href = "/reservation/signup";
            }
        } 
        else {
            console.error("Error:", xhr.statusText);
        }
    };

    // 에러 처리
    xhr.onerror = function() {
        console.error("Error:", xhr.statusText);
    };

    // 데이터 전송
    xhr.send(jsonData);
}
</script>

</body>
</html>