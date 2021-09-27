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
		url:"/BoardModifyAjax.do",
		type:"POST",
		data:$("#modifyForm").serialize(),
		dataType:"JSON",
		success:function(){
			alert("수정하였습니다");
			location.href = "/boardList.do";
		}
	})
}
</script>
</head>
<body>
<form id="modifyForm">
<table>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>내용</td>
		<td>저자</td>
	</tr>
	<tr>
		<td><input type="text" name="board_num" value="${vo.board_num }" readonly="readonly" /></td>
		<td><input type="text" name="board_title" /></td>
		<td><input type="text" name="board_content" /></td>
		<td><input type="text" name="board_author" value="${vo.board_author }" readonly="readonly"/></td>
	</tr>
</table>
</form>
<button type="button" onclick="modify()">수정</button>
</body>
</html>