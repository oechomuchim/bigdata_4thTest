<%@page import="product.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:useBean id="dto" class="product.ProductDTO"></jsp:useBean>
		<jsp:setProperty property="*" name="dto"/>
		<%
			ProductDAO dao = new ProductDAO();
			dao.update(dto);
		%>
		상품 정보 수정이 완료되었습니다.
		<br>
		<button type="button"><a href="main.jsp">홈으로 가기</a></button>
	</body>
</html>