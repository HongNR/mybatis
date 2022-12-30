<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동적쿼리 작성하기</title>
</head>
<body>
	<h2><a href="${path}/emp/empallList.do">사원조회</a></h2>
	<h2><a href="${path}/selectDept.do?deptId=D5">부서조회</a></h2>
	<h2><a href="${path}/boardView.do?boardNo=21">게시글 조회</a></h2>

</body>
</html>