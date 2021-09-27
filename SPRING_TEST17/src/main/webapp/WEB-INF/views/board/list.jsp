<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function list(page){
		$.ajax({
			url:"/ListAjax.do",
			type:"GET",
			data:{page:page, type:$("#type option:selected").val(), keyword:$("#keyword").val()},
			dateType:"JSON",
			success:function(result){
				console.log(result.list)
				$("#paging").empty();
				$("#tbody").empty();
				var list = result.list;
				for(var i = 0; i < list.length; i++){
				var html = "<tr>"
					html += "<td>"+list[i].board_num+"</td>"
					html += "<td><a href='/boardDetail.do?board_num="+list[i].board_num+"'>"+list[i].board_title+"</a></td>"
					html += "<td>"+list[i].board_day+"</td>"
					html += "<td>"+list[i].board_author+"</td>"
					html += "<td>"+list[i].board_view+"</td>"
					html += "</tr>"
					$("#tbody").append(html)
				}
				if(result.prev){
					$("#paging").append("<button onclick = list("+Number(page-1)+")>이전</button>");
				}
				for(var i = result.startPage; i <= result.endPage; i++){
					$("#paging").append("<button onclick = list("+i+")>"+i+"</button>");
				}
				if(result.next){
					$("#paging").append("<button onclick = list("+Number(page+1)+")>다음</button>");
				}
			}
		})
		
	}
	$(function(){
		list(1)
	})
	function logout(){
		$.ajax({
			url:"/logout.do",
			type:"GET",
			dataType:"JSON",
			success:function(result){
				alert("로그아웃 하였습니다.");
				location.href = "/";
			}
		})
	}
</script>
</head>
<body>
${id }
<h1>게시판 연습</h1>
<label>검색</label>
	<select id="type">
		<option value="board_title">제목</option>
		<option value="board_author">작성자</option>
	</select>
<label>검색</label>
	<input type="text" id="keyword" />
	<button type="button" onclick="list(1)">검색</button>
<table border="1" width = "70%">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>날짜</td>
		<td>저자</td>
		<td>조회수</td>
	</tr>
	<tbody id="tbody"></tbody>
</table>
<div id="paging"></div>
<a href="/boardInsert.do"><button>게시물 추가</button></a>
<a href="/userDetail.do?user_id=${id}"><button>내 정보</button></a>
<button type="button" onclick="logout()">로그아웃</button>
</body>
</html>