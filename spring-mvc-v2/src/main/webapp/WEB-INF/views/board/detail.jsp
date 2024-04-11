<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%pageContext.setAttribute("CRLF", "\r\n");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
    <p>이름 : <span class="editable">${detail.NAME}</span></p>
    <p>주민번호 : <span class="editable" id="residentId">${detail.RESIDENT_ID}</span></p>
    <p>주소 : <span class="editable">${detail.ADDRESS}</span></p>
    <p>성별 : <span class="editable">${detail.GENDER}</span></p>
    <p>전화번호 : <span class="editable">${detail.PHONE_NUMBER}</span></p>

    <!-- 버튼 클릭 시 페이지 이동 -->
    <button onclick="goToEditPage()">수정</button>
  <div>
    <form id="deleteForm" method="post" action="/board/delete">
    <!-- _method 필드를 사용하여 DELETE 요청을 시뮬레이트 -->
    <input type="hidden" name="_method" value="delete" />
    <!-- 주민번호 값을 hidden input으로 전달 -->
    <input  type="hidden" id="residentId" name="residentId" value="${detail.RESIDENT_ID}" />
    <!-- 삭제 버튼 -->
    <input type="button" name="delete_button" value="삭제" onclick="submitForm()" />
</form>
</div>
	
    <script>
     // edit 페이지로 이동하는 함수
        function goToEditPage() {
            // 주민번호 가져오기
            let residentId = document.getElementById('residentId').innerText;
         // URL 생성
            let url = '/board/edit/' + encodeURIComponent(residentId);

            // 새로운 페이지로 이동
            window.location.href = url;
        }
        function submitForm() {
            // 주민번호 가져오기
            let residentId = document.getElementById('residentId').innerText;
            // URL 생성
            let url = '/board/delete/' + encodeURIComponent(residentId);
            // 폼의 action 속성 설정
            document.getElementById('deleteForm').action = url;
            // 폼 제출
            document.getElementById('deleteForm').submit();
        }
    </script>
</body>
</html>