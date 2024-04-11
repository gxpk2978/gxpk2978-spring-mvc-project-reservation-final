<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Seat Selection</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .seat-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 10px;
            margin-top: 20px;
        }

        .seat-label {
            display: inline-block;
            width: 50px;
            height: 50px;
            background-color: #e0e0e0;
            border-radius: 10px;
            text-align: center;
            line-height: 50px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            font-weight: bold;
            color: #333;
        }

        .seat-label:hover {
            background-color: #bfbfbf;
        }

        select, button {
            display: block;
            width: 100%;
            padding: 10px;
            margin-top: 20px;
            border: none;
            border-radius: 5px;
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        select:hover, button:hover {
            background-color: #45a049;
        }

        button {
            background-color: #008CBA;
            margin-top: 30px;
        }

        button:hover {
            background-color: #004C7E;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>좌석 선택</h1>
    <form id="reservationForm" method="post" onsubmit="submitReservation(event)">
        <div class="seat-container">
            <% for(int i=1; i<=9; i++) { %>
                <input type="radio" id="seat<%= i %>" name="selectedSeat" value="<%= i %>">
                <label class="seat-label" for="seat<%= i %>">Seat <%= i %></label>
            <% } %>
        </div>
        
        <div>
            <h2>인원수 선택</h2>
            <select id="numberOfPeople" name="numberOfPeople">
                <option value="1">1 명</option>
                <option value="2">2 명</option>
                <option value="3">3 명</option>
                <option value="4">4 명</option>
            </select>
        </div>
        <div>
            <button type="submit">예약 확인</button>
        </div>
    </form>
</div>

<script>
function submitReservation(event) {
    event.preventDefault(); // 폼 제출 방지
    
    var currentUrl = window.location.href;

 // URL에서 customer_id 값을 추출합니다.
 var customerIdIndex = currentUrl.indexOf("/reservation/reservation/") + "/reservation/reservation/".length;
 var customerId = currentUrl.substring(customerIdIndex);

 // customerId를 확인합니다.
 console.log("고객 ID:", customerId);
    
    
    
    var formData = {
        selectedSeat: document.querySelector('input[name="selectedSeat"]:checked').value,
        numberOfPeople: document.getElementById("numberOfPeople").value,
        customer_id: customerId // 여기에 고객 ID 추가
    };
     console.log(formData,'느아느아')
    var jsonData = JSON.stringify(formData);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/reservation/reservation/customer_id"); // 서버 엔드포인트 URL 변경
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onload = function() {
        if (xhr.status == 200) {
            var data = JSON.parse(xhr.responseText);
            // 성공적인 응답 처리
            console.log("데이타 잘 받아와지나 : ",data);
            alert("예약 완료되었습니다.");
            window.location.href = "/createReservation"
            
        } else {
            console.error("Error:", xhr.statusText);
        }
    };
    xhr.onerror = function() {
        console.error("Error:", xhr.statusText);
    };
    xhr.send(jsonData);
}
</script>

</body>
</html>