<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function join(){
	$.ajax({
		url:"/joinAjax.do",
		type:"POST",
		data:$("#joinForm").serialize(),
		dataType:"JSON",
		success:function(result){
			var msg = result.msg;
			var result = result.result;
			
			alert(msg);
			
			if(result == 0){
				location.href = "/join.do";
			}else{
				location.href = "/";
			}
			
		}
	})
}
</script>
</head>
<body>
<h1>회원가입</h1>
<form id="joinForm">
<table>
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
	</tr>
	<tr>
		<td><input type="text" name="user_num" value="${max }" readonly="readonly" /></td>
		<td><input type="text" name="user_id" /></td>
		<td><input type="text" name="user_pw" /></td>
		<td><input type="text" name="user_name" /></td>
	</tr>
</table>
</form>
<button type="button" onclick="join()">회원가입</button>
<a href="/"><button>홈으로</button></a>
</body>
</html>