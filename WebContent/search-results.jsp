<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<body>
	<ul>
		<c:forEach items="${vendors}" var="vendor" >
			<li>${vendor.name}<br>
			${vendor.rating}<br>
			${vendor.address}<br>
			<a href="${vendor.website}">${vendor.website}</a><br>
			${vendor.phoneNo}</li>
		</c:forEach>
	</ul>
</body>
</html>