<%@page import="product.ProductDTO"%>
<%@page import="product.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body>
		<jsp:useBean id="dto" class="product.ProductDTO"></jsp:useBean>
		<!-- import + new -->
		<jsp:setProperty property="*" name="dto"/>
		<%
			ProductDAO dao = new ProductDAO();
			ProductDTO dto2 = dao.select(dto);
		%>
		<center>
		<h1>상품 검색</h1>
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
		
		<h2><%= dto.getId() %></h2>로 검색된 결과 입니다 :)<br>
		<table id="selectJsp_table" border="1" align="center">
			<tr>
				<td>상품 아이디</td>
				<td><%= dto2.getId() %></td>
			</tr>
			<tr>
				<td>상품 설명 제목</td>
				<td><%= dto2.getTitle() %></td>
			</tr>
			<tr>
				<td>상품 설명 내용</td>
				<td><%= dto2.getContent() %></td>
			</tr>
			<tr>
				<td>상품 가격</td>
				<td><%= dto2.getPrice() %></td>
			</tr>
		</table>
		<br>	
		<button type="button"><a href="main.jsp">홈으로 가기</a></button>
		</center>
	</body>
</html>