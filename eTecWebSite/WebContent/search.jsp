<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="search.css">
<title>eTec - Search</title>
</head>
<body>
	<%@page import="eTecWebSite.DataBase.DataBase"%>
	<%
		String code = (String) request.getParameter("code");
		DataBase data = new DataBase();
		String[] package1 = data.Package(code);
		String Json = "'{" + package1[0] + "}'";
	%>

	<header></header>
	<div ID="conteiner">
		<div ID="left">
			<div ID="cont">
				<form action="search.jsp" method="GET" ID="cont">
					<input type="text" name="code" value="<%=code%>"><br>
					<button type="submit" value="Submit">Search</button>
				</form>
			</div>
			<div ID="tit">
				<p>Enter the package code</p>
			</div>
		</div>
		<div ID="right">
			<table background=package.png height=500 width=480>
				<tr>
					<td>
						<p ID="iteb">
							Iterations(binary):
							<%=package1[1]%></p>
						<br>
						<p ID="itei">
							Iterations(interpolation):
							<%=package1[2]%></p>
					</td>
				</tr>
				<tr>
					<td>
					<form action="search2.jsp" method="GET">
							<input type="hidden" name="code" value="<%=code%>"><br>
							<button type="submit" value="Submit" ID="deliver"></button>
						</form>
						<p ID="est"></p> <br>
						<p ID="num"></p>
						
					</td>
				</tr>
			</table>
		</div>
	</div>

	<script>
		var obj = JSON.parse(
	<%=Json%>
		);
		document.getElementById("num").innerHTML = "Code: " + obj.code;
		if (obj.status == 0) {
			document.getElementById("est").innerHTML = "Status: on the road";
		}
		if (obj.status == 1) {
			document.getElementById("est").innerHTML = "Status: received";
		}
		if (obj.status == 2) {
			document.getElementById("est").innerHTML = "Status: delivered";
		}
	</script>
	<footer></footer>
</body>
</html>