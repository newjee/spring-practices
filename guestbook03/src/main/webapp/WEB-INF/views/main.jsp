<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<% request.setAttribute("newline", "\n"); %>

<html>
<head>
    <title>guestbook</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">


</head>
<body>

<div id="container">
    <div id="content">
        <div id="guestbook">
            <form action="${pageContext.request.contextPath}/add"
                  method="post">
                <table border=1 width="500">
                    <tr>
                        <td>이름</td>
                        <td><input type="text" name="name"></td>
                        <td>비밀번호</td>
                        <td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td colspan=4><textarea name="contents" id="contents"></textarea></td>
                    </tr>
                    <tr>
                        <td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
                    </tr>
                </table>
            </form>
            <ul>
                <c:forEach items="${list }" var="vo" varStatus="status">
                        <table border=1 width="500">
                            <tr>
                                <td>${vo.name }</td>
                                <td>${vo.regDate }</td>
                                <td><a href="${pageContext.request.contextPath }/delete?no=${vo.no }">삭제</a>
                                </td>
                            </tr>
                            <tr>
                                <td colspan=4>${vo.contents}
                                </td>
                            </tr>
                        </table>
                </c:forEach>
            </ul>
        </div>
    </div>

</div>
</body>
</html>