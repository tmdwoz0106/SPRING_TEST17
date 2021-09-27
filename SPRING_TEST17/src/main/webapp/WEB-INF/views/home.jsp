<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function login(){
	$.ajax({
		url:"/login.do",
		type:"POST",
		data:$("#loginForm").serialize(),
		dataType:"JSON",
		success:function(result){
			var vo = result.vo;
			if(vo.msg != null){
				alert(vo.msg);
			}else{
				alert("환영합니다.")
				location.href = "/boardList.do";
			}
		}
	})
	
}	
</script>
</head>
<body>
<form id="loginForm">
<table>
	<tr>
		<td>아이디</td>
		<td>비밀번호</td>
	</tr>
	<tr>
		<td><input type="text" name="user_id" /></td>
		<td><input type="text" name="user_pw" /></td>
	</tr>
</table>
</form>
<button type="button" onclick="login()">로그인</button> |
<a href="/join.do"><button>회원가입</button></a>
</body>
</html>
