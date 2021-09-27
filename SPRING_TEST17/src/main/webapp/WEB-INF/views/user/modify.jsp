<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function modify(){
	$.ajax({
		url:"/userModifyAjax.do",
		type:"POST",
		data:$("#modifyForm").serialize(),
		dataType:"JSON",
		success:function(result){
			alert("수정 성공");
			location.href = "/boardList.do";
		}
	})
}
</script>
</head>
<body>
<h1>회원 수정 연습</h1>
<form id="modifyForm">
	<table>
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
		</tr>
		<tr>
			<td><input type="text" name="user_id" value="${vo.user_id}" readonly="readonly"/></td>
			<td><input type="text" name="user_pw" /></td>
			<td><input type="text" name="user_name" /></td>
		</tr>
	</table>
</form>
<button type="button" onclick="modify()">수정하기</button>
<a href="/boardList.do"><button>홈으로</button></a>
</body>
</html>