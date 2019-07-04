<%@page import="product.ProductDTO"%>
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
	<!-- import + new -->
	<jsp:setProperty property="*" name="dto"/>
		<%
			ProductDAO dao = new ProductDAO();
			dao.insert(dto);
		%>
		<center>
		<h1>상품 삽입</h1>
		<table id="main_table">
			<tr>
				<a href="main.jsp">홈 | </a>
			</tr>
			<tr>
				<a href="insert.html">상품 등록 | </a>
			</tr>
			<tr>
				<a href="select.html">상품 검색 | </a>
			</tr>
			<tr>
				<a href="selectAll.jsp">상품 전체 검색 | </a>
			</tr>
			<tr>
				<a href="update.html">상품 수정 | </a>
			</tr>
			<tr>
				<a href="delete.html">상품 삭제</a>
			</tr>
		</table>
		상품 등록 완료!
		<br>
		<button type="button"><a href="main.jsp">홈으로 가기</a></button>
		</center>
	</body>
</html>