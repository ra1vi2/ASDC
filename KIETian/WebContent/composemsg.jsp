<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compose</title>
</head>
<body>
<%@ include file="viewhome.jsp" %>


<div align="left" style="background-color:rgb(173, 173, 133); ;margin-left: 208px;margin-top: 6.95cm; height:12cm ; ">
<% boolean result = (Boolean)request.getAttribute("result");
if(result){ %>
<h5 align="center">Message Sent</h5><%} %>
<form action="composemsg" method="post">
<div style="padding-top: 1cm">
<h4 style="color: highlighttext;">To :</h4>
<input style="margin-left: 1.6cm;width: 25cm" type="text" name="msgto">
<h4 style="color: highlighttext;">About :</h4>
<input style="margin-left: 1.6cm; width: 25cm" type="text" name="msgabout">
<div style="margin-top:1cm;background-color:#f1f1f1;width: auto ;padding-top: 5px;">
<h4 style="color: highlighttext;">Message :</h4>
</div>
<div style="padding-top: 2cm">
<textarea  name="msg_content" style="width: 20cm;height: 4cm"></textarea>
</div>
<input style="margin-left: 25cm" type="submit" value="Send">

</div>	
</form>
</div>
</body>
</html>