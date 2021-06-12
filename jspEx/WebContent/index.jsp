<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href ="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">



<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="./index.jsp">Home</a>
			</div>
		</div>
	</nav>
	<%! 
		String greeting = "웹쇼핑몰에 오신 것을 환영합니다.";
		String tagline = "Welcome to web Market";
	%>
	
	<div class="jumbotron">
		<div class="container">
			<div class="display-3">
				<h1><%= greeting %> </h1>
			</div>
		</div>
		<div class="container">
			<div class="text-center">
				<h3><%=tagline%></h3>
				<div>
					<%
						Date day = new Date();
					String am_pm;
					int hour = day.getHours();
					int minute = day.getMinutes();
					int second = day.getSeconds();
					if (hour / 12 == 0) {
						am_pm = "AM";
					} else {
						am_pm = "PM";
						hour = hour - 12;
					}
					String CT = hour + ":" + minute + ":" + second + ":" + am_pm;
					out.println("현재 접속 시각 : " + CT + "\n");
					%>
				</div>
			</div>
		</div>
	</div>


	<hr>
	<footer class="container">
		<p>&copy; WebMarket</p>
	</footer>
	
</body>
</html>