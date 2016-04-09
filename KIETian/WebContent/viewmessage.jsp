<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Messages</title>
<style>
.button {
     background:none!important;
     border:none; 
     padding:0!important;
     font: inherit;
     /*border is optional*/
     border-bottom:1px solid #444; 
     cursor: pointer;
}</style>

 
</head>
<body>

<%@ include file="viewhome.jsp" %>


<div align="left" style="background-color:rgb(173, 173, 133); ;margin-left: 208px;margin-top: 6.95cm; height:12cm ; ">

 <h3>Inbox Messages</h3>
 <form action="showmsg" method="post">
 <table >
 <tr>
 <td >From</td>
 	
 <td>About</td>
 
 
 <td>Time</td> 
 </tr>
 <c:forEach items="${list}" var="x">
 <tr>
 <td><input type="hidden" name="from" value="${x.from}">${x.from}</td>
  <td><input type="hidden" name="about" value="${x.about}">${x.about}</td> 
  <td><input type="hidden" name="time" value="${x.time}">${x.time}</td> 
    <td><button style="color:blue ;background:none!important;border:none; padding:0!important; font: inherit;"  type="submit" name="content" value="${x.msg_content}">Read More...</button></td> 
  
  </tr>
  
</c:forEach>

</table>
</form>
<div align="right">
<form action="composemsg.jsp" method="post">
<button style="color: white; background-color: red" >Compose</button><br><br>
</form>
<form action="sentmsg" method="post">
<button style="color: white; background-color: red" >Sent Msg</button>	
</form>
</div>
</div>
</body>

</html>