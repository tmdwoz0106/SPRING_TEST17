<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function remove(){
	$.ajax({
		url:"/userDelete.do",
		type:"POST",
		data:$("#deleteForm").serialize(),
		dataType:"JSON",
		success:function(result){			
				alert("탈퇴하였습니다");
				location.href = "/";
			
		}
		
	})
}
</script>
</head>
<body>
<form id="deleteForm">
<table>
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>비번</td>
		<td>이름</td>
	</tr>
	<tr>
		<td><input type="text" name="user_num" value="${vo.user_num}" readonly="readonly" /></td>
		<td><input type="text" name="user_id" value="${vo.user_id }" readonly="readonly" /></td>
		<td><input type="text" name="user_pw" value="${vo.user_pw }" readonly="readonly" /></td>
		<td><input type="text" name="user_name" value="${vo.user_name }" readonly="readonly" /></td>
	</tr>
</table>
</form>
<button type="button" onclick="remove()">탈퇴</button>
<a href="/userModify.do?user_id=${id}"><button>수정</button></a>
<a href="/boardList.do"><button>홈으로</button></a>
</body>
</html>