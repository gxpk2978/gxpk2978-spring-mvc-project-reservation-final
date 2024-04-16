<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Reservation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            width: 600px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 30px;
            box-sizing: border-box;
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
            color: #333;
        }

        .seat-map {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            grid-gap: 10px;
            margin-bottom: 20px;
        }

        .room-button {
            width: 80px;
            height: 80px;
            background-color: #90EE90; /* 빈 방 배경색 */
            color: #fff;
            font-size: 18px;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .room-button.selected {
            background-color: #4169E1; /* 선택된 방 배경색 */
        }

        .room-button:disabled {
            background-color: #A9A9A9; /* 예약된 방 배경색 */
            cursor: not-allowed;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #666;
        }

        input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            margin-bottom: 20px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 15px;
            background-color: #4169E1;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #3156A3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Reservation</h1>
        <div class="seat-map">
            <c:forEach var="room" items="${rooms}">
                <c:choose>
                    <c:when test="${room.roomStatus eq 'empty'}">
                        <button class="room-button" type="submit" name="roomNumber" value="${room.roomNumber}">${room.roomNumber}</button>
                    </c:when>
                    <c:otherwise>
                        <button class="room-button" type="button" disabled>${room.roomNumber}</button>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
  <form id="putForm" method="post" action="javascript:void(0);">
    <label for="numberOfPeople">Number of people:</label>
    <input type="number" name="numberOfPeople" id="numberOfPeople" min="1">
    <input type="hidden" id="selectedRoom" name="roomNumber" value="">
    
    <!-- PUT 메서드를 사용하기 위한 숨겨진 필드 -->
    <input type="hidden" name="_method" value="put">

    <button class="button" type="submit">수정하기</button>
</form>

</div>

<script>
    // PUT 요청을 보내는 함수
    function sendPutRequest() {
    	 var form = document.getElementById("putForm");
         
         var url = window.location.href; // 현재 URL 가져오기
         var custom_id = url.substring(url.lastIndexOf('/') + 1); // URL에서 마지막 '/' 이후의 문자열 추출 (ID 부분)
       
         console.log(custom_id,  "custom_id");
         form.action = "/reservation/update/" + custom_id; // 수정 API URL로 변경
         form.submit(); // 폼 제출
        
    }

    document.addEventListener('DOMContentLoaded', function() {
        const roomButtons = document.querySelectorAll('.room-button');
        const selectedRoomInput = document.getElementById('selectedRoom');

        roomButtons.forEach(function(button) {
            button.addEventListener('click', function() {
                const roomNumber = this.value;
                selectedRoomInput.value = roomNumber;
            });
        });
    });

    // 수정하기 버튼을 누르면 PUT 요청 보내기
    var putButton = document.querySelector("#putForm button[type='submit']");
    putButton.addEventListener("click", function(event) {
        event.preventDefault(); // 기본 동작 중단
        sendPutRequest(); // PUT 요청 보내기
    });
</script>
    
    
</body>




</html>