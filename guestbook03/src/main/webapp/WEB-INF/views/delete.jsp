<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
</head>
<body>

	<div id="container">
		<div id="content">
			<div id="guestbook" class="delete-form">
				<form method="post" action="${pageContext.request.contextPath }/delete">
					<input type="hidden" name="a" value="delete">
					<input type='hidden' name="no" value="${param.no}">
					<label>비밀번호</label>
					<input type="password" name="password" value="${param.password}">
					<input type="submit" value="확인">
				</form>
				<a href="${pageContext.request.contextPath }">방명록 리스트</a>
			</div>
		</div>

	</div>
</body>
</html>