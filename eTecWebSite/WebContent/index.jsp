<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="index.css">
<title>eTec - Start Page</title>
</head>
<body>
	<%@page import="eTecWebSite.DataBase.DataBase"%>
	<%DataBase data = new DataBase();%>
	<header></header>
	<div ID="conteiner">
		<div ID="left">
			<div ID="cont">
				<form action="search.jsp" method="GET" ID="cont">
					<input type="text" name="code"><br>
					<button type="submit" value="Submit">Search</button>
				</form>
			</div>
			<div ID="tit">
				<p>Enter the package code</p>
			</div>
		</div>
		<div ID="right"></div>
	</div>
	<footer></footer>
</body>
</html>