<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Classes Status</title>
</head>
<body>
<%@ include file="viewhome.jsp" %>
<div align="left" style="background-color:rgb(173, 173, 133); ;margin-left: 208px;margin-top: 6.95cm; height:12cm ; ">
<h3>Free Classes</h3>
 <form action="engagefac" method="post">
 <table>
 <tr>
 <td>Sem</td>
 <td>Sec</td>
 <td>Facid</td>
 </tr>
 
 <c:forEach items="${freefacnsec}" var="x">
 <tr>
 <td><input type="hidden" name="sem" value="${x.sem}">${x.sem}</td>
  <td><input type="hidden" name="sec" value="${x.sec}">${x.sec}</td>
 <td><input type="hidden" name="fac_id" value="${x.fac_id}"></td>
   <td><button style="color:blue ;
                        background:none!important;border:none; 
                        padding:0!important; font: inherit;"  
                        type="submit" name="content" >Engage ${x.fac_id} in sem=${x.sem} sec=${x.sec}</button></td> 
  
 <td>
 </tr>
</c:forEach>

</table>
</form>
<div align="right">

<% String result =(String) request.getAttribute("result");
if(result=="true")
{%><h3>Done.</h3><%} else if(result=="error"){ %><h3>Error Occured. </h3><%} %>
</div>
 
</div>


</body>
</html>