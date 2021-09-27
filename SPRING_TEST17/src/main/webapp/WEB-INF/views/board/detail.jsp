<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function remove(){
	$.ajax({
		url:"/BoardDelete.do",
		type:"POST",
		data:$("#deleteForm").serialize(),
		dataType:"JSON",
		success:function(result){			
			    alert("삭제 하였습니다");
			    location.href = "/boardList.do";			
		}
	})
}


	function modalClose(){
	     $("#popup").fadeOut(); //페이드아웃 효과
	     $("#textArea").val("");
	 }
	function modalOpen(reply_group,reply_depth){
		$("#reply_group").val(reply_group);
		$("#reply_depth").val(reply_depth);
		$("#popup").css('display','flex').hide().fadeIn();
	}
	function addReply(){
		var reply = $("#textArea").val();
		$("#reply_content").val(reply);
		$("#replyForm").submit();
		modalClose();
	}

	function delete_reply(reply_num,board_num){	
		if (confirm("정말 삭제하시겠습니까??") == true){    
			$.ajax({
				url:"/reply_delete.do",
				type:"POST",
				data:{reply_num:reply_num,board_num:board_num},
				dataType:"JSON",
				success:function(result){					
						alert("삭제하였습니다");
						location.href = "/boardDetail.do?board_num="+$("#Board_num").val();					
				}
			})		  
		}
	}
</script>
</head>
<body>
<h1>상세보기 연습</h1>
<c:if test="${vo.board_author eq id}">
<button type="button" onclick = "remove()">삭제</button> | 
<a href="/BoardModify.do?board_num=${vo.board_num }"><button type="button">수정</button></a> |
</c:if>
<a href="/boardList.do"><button>홈으로</button></a>
<form id="deleteForm">
<table border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>내용</td>
		<td>저자</td>
		<td>날짜</td>
		<td>조회수</td>
	</tr>
	<tr>
		<td><input type="text" id="Board_num" name="board_num" value="${vo.board_num }" readonly="readonly" /></td>
		<td><input type="text" name="board_title" value="${vo.board_title }" readonly="readonly" /></td>
		<td><input type="text" name="board_content" value="${vo.board_content }" readonly="readonly" /></td>
		<td><input type="text" name="board_author" value="${vo.board_author }" readonly="readonly" /></td>
		<td><input type="text" name="board_day" value="${vo.board_day }" readonly="readonly" /></td>
		<td><input type="text" name="board_view" value="${vo.board_view }" readonly="readonly" /></td>
	</tr>
</table>
</form>
<br />
<button onclick="modalOpen(0,0)">댓글 달기</button>

			
<div>
	<c:forEach var="reply" items="${list}">
		<div>
			<c:forEach end="${reply.reply_depth }" begin="0">
				&nbsp;
			</c:forEach>
			
			<c:if test="${reply.reply_depth != 0}">
				L 
			</c:if>
			${id} | ${reply.reply_content} | ${reply.reply_day} <a href="#" onclick="modalOpen(${reply.reply_group},${reply.reply_depth+1})">댓글 달기</a>
			<c:if test="${id eq reply.reply_author }">
				<button onclick="delete_reply(${reply.reply_num},${reply.board_num })" type="button">삭제</button>
			</c:if>
		</div>
	</c:forEach>	

</div>
<div class="container">
  <div class="popup-wrap" id="popup">
    <div class="popup">
      <div class="popup-body">
        <div class="body-content">
          <div class="body-contentbox">
            <textarea rows="5" cols="100" id="textArea"></textarea>
          </div>
        </div>
      </div>
      <div class="popup-foot">
        <span class="pop-btn confirm" id="confirm" onclick="addReply()">확인</span>
        <span class="pop-btn close" id="close" onclick="modalClose()">닫기</span>
      </div>
    </div>
</div>
</div>

<div>
<form id="replyForm" method="get" action="/reply_insert.do">
	<input type="text" name="reply_num" id="reply_num" value="${max}" />
	<input type="text" name="board_num" id="board_num" value="${vo.board_num }"  />
	<input type="text" name="reply_content" id="reply_content"  />
	<input type="text" name="reply_author" id="reply_author" value="${id}"/>
	<input type="text" name="reply_day" id="reply_day"  />
	<input type="text" name="reply_group" id="reply_group"  value="0"/>
	<input type="text" name="reply_depth" id="reply_depth" value="0"/>
</form>
</div>
</body>
</html>