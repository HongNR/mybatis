<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>제목 : ${board.boardTitle }</p>
	<p>작성자 : ${board.boardWriter }</p>
	<p>내용 : ${board.boardContent }</p>
	<p>일자 : ${board.boardDate }</p>
	<p>조회수 : ${board.boardReadCount }</p>
	<h3>댓글</h3>
	<c:forEach var="c" items="${board.comments }" varStatus="vs">
		<p>${vs.count} ${c.boardCommentWriter } ${c.boardCommentContent } 
			${c.boardCommentDate }</p>
	</c:forEach>
</body>
</html>