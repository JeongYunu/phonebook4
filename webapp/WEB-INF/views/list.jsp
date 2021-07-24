<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 리스트${ pageContext.request.contextPath }</h1>
	<p>입력한 정보 내역입니다.</p>

	<c:forEach items="${ requestScope.personList }" var="pListVo">
		<table border="1">
			<tr>
				<td>이름</td>
				<td>${ pListVo.name }</td>
			</tr>
			<tr>
				<td>핸드폰</td>
				<td>${ pListVo.hp }</td>
			</tr>
			<tr>
				<td>회사</td>
				<td>${ pListVo.company }</td>
			</tr>
			<tr>
				<td><a href="${ pageContext.request.contextPath }/updateForm?personId=${ pListVo.personId }">[수정폼]</a></td>
				<td><a href="${ pageContext.request.contextPath }/delete?personId=${ pListVo.personId }">[삭제]</a></td>
			</tr>
		</table>
		<br>
	</c:forEach>
	
	<a href="${ pageContext.request.contextPath }/writeForm">전화번호 작성</a>

</body>
</html>