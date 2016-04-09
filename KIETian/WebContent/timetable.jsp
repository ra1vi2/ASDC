<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"    prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Time Table</title>
</head>
<body>
<%@ include file="viewhome.jsp" %>
<div align="left" style="background-color:rgb(173, 173, 133); ;margin-left: 208px;margin-top: 6.95cm; height:12cm ; ">
<h3>Time Table</h3>
 <table>
 <tr>
 <td>Subject</td>
 <td>Faculty</td>
 <td>Time</td>
 </tr>
 
 <c:forEach items="${table}" var="x">
 <tr>
 <td>${x.subject}</td>
  <td>${x.fac_id}</td>
 <td>${x.time}</td>
 </tr>
</c:forEach>

</table>
</div>
</body>
</html>