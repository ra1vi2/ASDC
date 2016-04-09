<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"    prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Detail</title>
</head>
<body>
<%@ include file="viewhome.jsp" %>
<%-- c:forEach items="${list}" var="list">
<h1>${list.name}</h1>
</c:forEach> --%>
<div align="left" style="background-color:rgb(173, 173, 133); ;margin-left: 208px;margin-top: 6.95cm; height:12cm ; ">
 <h3>Subject-Wise Attendance</h3>
 <table>
 <tr>
 <td>Subject</td>
 <td>Attendance %</td>
 
 </tr>
 
 <c:forEach items="${list}" var="x">
 <tr>
 <td>${x.subject}</td>
  <td>${x.sub_att}</td>
 </tr>
</c:forEach>

</table>
<div align="right">
<a href="">Send a Message</a>
</div>
</div>

</body>
</html>