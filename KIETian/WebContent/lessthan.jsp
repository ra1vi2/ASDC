<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"    prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Attendance Criteria</title>
</head>
<body>
<div>
<%@ include file="viewhome.jsp" %>
 <div align="left" style="background-color:rgb(173, 173, 133); ;margin-left: 208px;margin-top: 6.95cm; height:12cm ; ">
<h3>Input The Criteria to Check</h3>
<form action="lessthanservlet" method="post">
<input type="text" name="criteria">
<input id="submit" type="submit" value="check">
</form>

<h3>Student List</h3>

 <table>
 <tr>
 <td>Name</td>
 <td>Roll No</td>
 <td>Attendance</td>
 </tr>
 
 <c:forEach items="${list}" var="x">
 <tr>
 <td>${x.name}</td>
  <td><a href="studentdetail?rollno=${x.rollno}">${x.rollno}</a></td>
 <td>${x.attendance}</td>
 </tr>
 <input type="hidden" name="rollno" value="${x.rollno}">
 </c:forEach>
</table>
<div align="right">
<form action="sendlessthan" method="post">
<input align="right" type="submit" value="Send A Warning Message to All">
</form>
 <% String result = (String)request.getAttribute("result");
 
// System.out.println(" JSP wala"+result);
if(result=="sent")
{%><h3>All Messages Sent.</h3><%} else if(result=="fail"){ %><h3>No Messages Sent.</h3><%} %>
 
 </div>

</div>
</div>
</body>
</html>