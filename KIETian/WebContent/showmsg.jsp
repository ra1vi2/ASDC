<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"    prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" >  
function showto() {  
var data="<form action='composemsg'>To:<input type='text' name='msgto'><input type='submit' value='Send'> </form>";  
  
document.getElementById('mylocation').innerHTML=data;  
 }  
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Message Inbox</title>
</head>
<body>
<%@ include file="viewhome.jsp" %>


<div align="left" style="background-color:rgb(173, 173, 133); ;margin-left: 208px;margin-top: 6.95cm; height:12cm ; ">

<div  style="float: left;">
<form method="get" action="reply">

<input type="hidden" name="from" value="${from}">
<input type="hidden" name="about" value="${about}">
<input type="image" alt="reply" src="images/reply.png" title="reply" >
</form>
</div>
<div  style="margin-left: 2cm" align="right">

<form method="post" >
<input type="hidden" name="msgabout" value="${about}">
<input type="hidden" name="msg_content" value="${msg_content}">
<input type="submit" onclick="showto()">
<input type="image" src="images/forward.png" title="forward" onclick="showto()">
</form>
<div id="mylocation"></div>
</div>

<div style="padding-top: 1cm">
<h4 style="color: highlighttext;">From : ${from}</h4><br>
<h4 style="color: highlighttext;">About : ${about}</h4><br>
<h4 style="color: highlighttext;">Time : ${time}</h4><br>
<div style="margin-top:1cm;background-color:#f1f1f1;width: auto ;padding-top: 5px;">
<h4 style="color: highlighttext;">Message :</h4>
</div>
<h5 style="padding-top: 2cm">${msg_content}</h5>
</div>	
</div>
</body>
</html>