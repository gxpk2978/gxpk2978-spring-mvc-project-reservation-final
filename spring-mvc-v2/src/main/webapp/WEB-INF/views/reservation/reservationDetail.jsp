<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>예약 상세 정보</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        td {
            background-color: #fff;
        }
        .button-container {
            text-align: center;
            margin-top: 20px;
        }
        /* 스타일링된 버튼과 링크 */
        .button,
        a.button {
            padding: 10px 20px;
            background-color: #4169E1;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-right: 10px;
            text-decoration: none; /* 기본 밑줄 제거 */
            display: inline-block; /* 인라인 요소처럼 동작하도록 설정 */
            transition: background-color 0.3s ease;
        }

        /* 호버 효과 */
        .button:hover,
        a.button:hover {
            background-color: #3156A3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>예약 상세 정보</h1>
        <table>
            <tr>
                <th>고객 ID</th>
                <td>${total.CUSTOMER_ID}</td>
            </tr>
            <tr>
                <th>이름</th>
                <td>${total.NAME}</td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td>${total.PHONE_NUMBER}</td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>${total.EMAIL}</td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td>${total.PASSWORD}</td>
            </tr>
            <tr>
                <th>예약 ID</th>
                <td>${total.RESERVATION_ID}</td>
            </tr>
            <tr>
                <th>방 번호</th>
                <td>${total.ROOMNUMBER}</td>
            </tr>
            <tr>
                <th>인원 수</th>
                <td>${total.NUMBER_OF_PEOPLE}</td>
            </tr>
            <tr>
                <th>방 상태</th>
                <td>${total.ROOMSTATUS}</td>
            </tr>
        </table>
        <div class="button-container">
            <!-- 수정 링크 -->
            <a href="/reservation/reservationEdit/${total.CUSTOMER_ID}" class="button">예약 수정하기</a>
    
            <!-- 삭제 버튼 -->
            <form id="deleteForm" method="post" action="/reservation/delete">
                <input type="hidden" id="roomNumber" name="roomNumber" value="${total.ROOMNUMBER}">
                
                <!-- DELETE 메서드를 사용하기 위한 숨겨진 필드 -->
                <input type="hidden" name="_method" value="delete">
            
                <button class="button" type="submit">예약 삭제하기</button>
            </form>
        </div>
    </div>
</body>
</html>