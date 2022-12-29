<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원조회결과</title>
</head>
<body>
	<h2>사원조회결과</h2>
	<form action="${pageContext.request.contextPath }/searchEmp.do">
		<table>
			<tr>
				<td>
					<select name="type">
						<option value="emp_id">사원번호</option>
						<option value="emp_name">사원명</option>
						<option value="email">이메일</option>
						<option value="phone">전화번호</option>
					</select>
				</td>
				<td>
					<input type="text" name="keyword"/>
				</td>
			</tr>
			<tr>
				<td>
					성별조회
				</td>
				<td>
					<input type="radio" name="gender" value="M">남
					<input type="radio" name="gender" value="F">여
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="조회"/>
				</td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<th>사원번호</th>
			<th>사원이름</th>
			<th>주민번호</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>부서코드</th>
			<th>직책코드</th>
			<th>급여레벨</th>
			<th>급여</th>
			<th>보너스</th>
			<th>매니저아이디</th>
			<th>입사일</th>
		</tr>
		<c:choose>
			<c:when test="${empty employees }">
				<tr>
					<td colspan="12">등록된 사원이 없습니다</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="e" items="${employees }">
					<tr>
						<td><c:out value="${e.empId }"/></td>
						<td><c:out value="${e.empName }"/></td>
						<td><c:out value="${e.empNo }"/></td>
						<td><c:out value="${e.email }"/></td>
						<td><c:out value="${e.phone }"/></td>
						<td><c:out value="${e.deptCode }"/></td>
						<td><c:out value="${e.jobCode }"/></td>
						<td><c:out value="${e.salLevel }"/></td>
						<td><fmt:formatNumber value="${e.salary }" type="currency"/></td>
						<td><fmt:formatNumber value="${e.bonus }" type="percent"/></td>
						<td><c:out value="${e.managerId }"/></td>
						<td><fmt:formatDate value="${e.hireDate }" type="both" pattern="yyyy/MM/dd E"/></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<div>
		${pageBar }
	</div>

</body>
</html>