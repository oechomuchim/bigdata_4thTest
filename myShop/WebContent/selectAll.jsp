<%@page import="java.util.ArrayList"%>
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
		<center>
		<h1>상품 전체 검색</h1>
		<table>
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
		
			<table id="selectAll_table" border="1" align="center">
			<tr>
				<td>상품 아이디</td>
				<td>상품 설명 제목</td>
				<td>상품 설명 내용</td>
				<td>상품 가격</td>
			</tr>
			
		<%
			ProductDAO dao = new ProductDAO();
			ProductDTO dto = new ProductDTO();
     		ArrayList list = dao.selectAll();
     		
     		for(int i=0; i<list.size(); i++) {
     			dto = (ProductDTO)list.get(i);
     		
		%>
		
			<tr>
				<td><%= dto.getId() %></td>
				<td><%= dto.getTitle() %></td>
				<td><%= dto.getContent() %></td>
				<td><%= dto.getPrice() %></td>
			</tr>
		<%
     		}
		%>
		</table>
		</center>
	</body>
</html>