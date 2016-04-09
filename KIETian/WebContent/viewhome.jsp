<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core"    prefix="c" %>
      <%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link rel="stylesheet" href="democss.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>

.button {
    position:absolute;
    bottom:10px;
    right:10px;
    width:100px;
    height:30px;
}
 

  body{width:97%;margin:auto;min-width:600px;max-width:2000px}
  
  .WebContainer{
    width: 100%;
    height: auto;
}

.articles{
    width:90%; /*Takes 90% width from WebContainer*/
    height: auto;
    margin: auto;
} 
   
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color:#f1f1f1;
      height: 100%;
    }
	element {
}
.h5, h5 {
    font-size: 14px;
}
.h4, .h5, .h6, h4, h5, h6 {
    margin-top: 10px;
    margin-bottom: -25px;
}
.h1, .h2, .h3, .h4, .h5, .h6, h1, h2, h3, h4, h5, h6 {
    font-family: inherit;
    font-weight: 500;
    line-height: 1.1;
    color: inherit;
}
    
    
body {
    font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
    font-size: 16px;
    line-height: 1.42857;
    color: #333;
}
  .style1 {font-size: xx-large}
.style3 {color: #990000}
  .style5 {font-size: 18px; }
  .style6 {font-size: 16px; }
  </style>
</head>
<body>

<div class="row">
<div class="col-sm-2 ">

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">

     <div align="center"><img src="images/Logo.jpg">
       
        <br>
           <span class="style9 style1 style3">KIETian   </span><br>
       
        <br>
        
		
        <br>
		
        <br>
        
		
        <br>
     </div>
	 <ul class="style6">
    <li> <p><span class="style3"><a href="semnsec?value=2-A">SEM II  SEC-A</a></span></p></li>
    <li>  <p><a href="semnsec?value=2-B">SEM II  SEC-B</a></p></li>
      <li><p><a href="semnsec?value=2-C">SEM II  SEC-C</a></p></li>
	  
	  
	  
	  <li><p><a href="semnsec?value=4-A">SEM IV  SEC-A</a></p></li>
	  <li><p><a href="semnsec?value=4-B">SEM IV  SEC-B</a></p></li>
	  <li><p><a href="semnsec?value=4-C">SEM IV  SEC-C</a></p></li>
	  <li><p><a href="semnsec?value=6-A">SEM VI  SEC-A</a></p></li>
	  <li><p><a href="semnsec?value=6-B">SEM VI  SEC-B</a></p></li>
	  <li><p><a href="semnsec?value=6-C">SEM VI  SEC-C</a></p></li>
	  <li><p><a href="semnsec?value=8-A">SEM VIII  SEC-A</a></p></li>
	  <li><p><a href="semnsec?value=8-B">SEM VIII  SEC-B</a></p></li>
	  <li><p><a href="semnsec?value=8-C">SEM VIII  SEC-C</a></p></li>
	  </ul>
    </div>
	 
 </div>
 </div>
 


	<div class="col-sm-10 ">
	
	<div class="container-fluid">
	
	
	 </div>
	 
	 
	 <div class="bg-1">
	 
	
	
<img src="images/banner.jpg" class="img-rounded" alt="Cinque Terre" width="1104" height="200">
	<%HttpSession sessions = request.getSession(false);
	
	if(session==null || session.getAttribute("facid")==null)
	{
		//
		response.sendRedirect("login.jsp");
	} else{
		String name =(String)session.getAttribute("facid");}
	%>
	<h5>Logged in as-:<a  href="#" class="style5"> <c:out value="${sessionScope.facid}"/> </a></h5>
	<a href="logout" class="style5" style="float:right;"> Logout</span></a>
	<div style="padding-left:210px" class="btn-group btn-group-justified"> </div>
	 </div>
	 <div class="btn-group btn-group-justified">
	 <a href="studentlist" class="btn btn-primary">Student List</a>
 
  <a href="lessthan.jsp" class="btn btn-primary">Less Attendence</a>
  <a href="facultyinsec" class="btn btn-primary">Faculty</a>
  <a href="timetable" class="btn btn-primary">Time Table</a>
  <a href="facatttoday" class="btn btn-primary">Faculty Attendence</a>
  <a href="classstatus" class="btn btn-primary">Classes Status</a>
  <a href="messages" class="btn btn-primary">Messages</a>
	 </div>
	 
  

  
 
</div>

</body>
</html>