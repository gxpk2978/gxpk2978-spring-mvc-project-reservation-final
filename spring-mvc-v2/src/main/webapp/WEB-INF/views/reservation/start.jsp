<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
	 <style>	 
        body {
           margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
        }
        .container {
            width: 100px;
            margin: 0 auto;
            margin-top: 100px;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h1 {
            margin-bottom: 20px;
        }
        form {
            margin-top: 20px;
        }
        input[type="text"], input[type="password"] {
            width: 30%;
            padding: 10px;
            margin-bottom: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 30%;
            padding: 10px;
            font-size: 16px;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            color: #fff;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        p {
            margin-top: 10px;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
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
    <img src="resources/image/image.jpg" alt="로그인 이미지"  style="width: 25%; border: 2px solid #ccc; border-radius: 10px;"><br>

    <h1>Log In</h1>
    <h1>커밋확인용</h1>
    <form  method="post">
        <input type="text" name="customer_id" placeholder="아이디"><br>
        <input type="password" name="password" placeholder="비밀번호"><br>
        <input type="submit" value="로그인">
    </form>
    <p><a href="/reservation/signup">회원가입</a></p>
</body>
</html>
