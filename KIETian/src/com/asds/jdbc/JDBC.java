package com.asds.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;










import ra1vi2.asds.DTO.FacatttodadayDTO;
import ra1vi2.asds.DTO.FacultyInsecDTO;
import ra1vi2.asds.DTO.MessageDTO;
import ra1vi2.asds.DTO.SemMain;
import ra1vi2.asds.DTO.StudentDetailDTO;
import ra1vi2.asds.DTO.StudentListDTO;
import ra1vi2.asds.DTO.TimeTableDTO;



public class JDBC {

	private static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		ResourceBundle rb = ResourceBundle.getBundle("db");
		String driverName = rb.getString("drivername");
		
		// Step -1 Load DataBase Driver
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName(driverName);
		System.out.println("Driver Loaded...");
		// Step -2 Creating Connection
		String url = rb.getString("dburl");
	    String userid = rb.getString("userid");
		String password = rb.getString("password");
		Connection con = DriverManager.getConnection(url,userid,password);
		if(con!=null){
			System.out.println("Connection Ready...");
			
		}	
		return con;
	}
public static boolean checksLogin(String email,String password) throws ClassNotFoundException, SQLException{
		
		boolean result = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
		con = getConnection();
		//Step -3 Query 
		 stmt = con.createStatement();
		// Step -4 Result 
		// select userid,password from user where userid='amit' and password='123'
	//System.out.println("1");
		 rs = stmt.executeQuery("select * from HOD where fac_id='"+email+"' and pass='"+password+"'");
		if(rs.next()){
			//System.out.println("2");
			result = true;
			
		}
		else
			System.out.println("unknown");
		}

		finally{
		// Step -5 Close the resources
		if(rs!=null){	
		rs.close();
		}
		if(stmt!=null){
		stmt.close();
		}
		if(con!=null){
		con.close();
		}
		}
		return result;
		
	}

public static List<SemMain> secStatus(String sem,String sec) throws ClassNotFoundException, SQLException{
	List<SemMain> list=new ArrayList<SemMain>();
	boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	SemMain status;
	ResultSet rs = null;
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1");
	
	 pstmt = con.prepareStatement("select * from sec_status where semester='"+sem+"' and section='"+sec+"'");
	 rs = pstmt.executeQuery();
	 while(rs.next()){
		status = new SemMain();
		status.setSec(rs.getString("semester"));
		status.setSem(rs.getString("section"));
		status.setStatus(rs.getString("status"));
		status.setRoomno(rs.getString("RoomNo"));
		
		list.add(status);
	}
	/* System.out.println("AfterJDBC "+rs.getString("status"));
	 System.out.println("After JDBC"+rs.getString("RoomNo"));*/
	}

	finally{
	// Step -5 Close the resources
	if(rs!=null){	
	rs.close();
	}
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return list;
	
}
public static List<StudentListDTO> studentlist(String sem,String sec) throws ClassNotFoundException, SQLException{
	List<StudentListDTO> list=new ArrayList<StudentListDTO>();
	boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	StudentListDTO status;
	ResultSet rs = null;
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1");
	 pstmt = con.prepareStatement("select name,roll_no,attendance from student_list where semester='"+sem+"' and section='"+sec+"'");
	 rs = pstmt.executeQuery();
	 while(rs.next()){
		status = new StudentListDTO();
		status.setName(rs.getString("name"));
		status.setRollno(rs.getString("roll_no"));
		status.setAttendance(rs.getString("attendance"));
		
		
		list.add(status);
	}
	/* System.out.println("AfterJDBC "+rs.getString("status"));
	 System.out.println("After JDBC"+rs.getString("RoomNo"));*/
	}

	finally{
	// Step -5 Close the resources
	if(rs!=null){	
	rs.close();
	}
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return list;
	
}
public static List<StudentListDTO> studentlistsem(String sem) throws ClassNotFoundException, SQLException{
	List<StudentListDTO> list=new ArrayList<StudentListDTO>();
	boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	StudentListDTO status;
	ResultSet rs = null;
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1");
	 pstmt = con.prepareStatement("select name,roll_no,attendance from student_list where semester='"+sem+"' ");
	 rs = pstmt.executeQuery();
	 while(rs.next()){
		status = new StudentListDTO();
		status.setName(rs.getString("name"));
		status.setRollno(rs.getString("roll_no"));
		status.setAttendance(rs.getString("attendance"));
		
		
		list.add(status);
	}
	/* System.out.println("AfterJDBC "+rs.getString("status"));
	 System.out.println("After JDBC"+rs.getString("RoomNo"));*/
	}

	finally{
	// Step -5 Close the resources
	if(rs!=null){	
	rs.close();
	}
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return list;
	
}

public static List<StudentListDTO> studentlessthan(String sem,String sec,String criteria) throws ClassNotFoundException, SQLException{
	List<StudentListDTO> list=new ArrayList<StudentListDTO>();
	//boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	StudentListDTO status;
	ResultSet rs = null;
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1"); 
	 System.out.println(criteria + "JDBC");
	 pstmt = con.prepareStatement("select name,roll_no,attendance from student_list where semester='"+sem+"' and section='"+sec+"' AND attendance < '"+criteria+"' ORDER BY  attendance ASC ");
	 rs = pstmt.executeQuery();
	 while(rs.next()){
		status = new StudentListDTO();
		status.setName(rs.getString("name"));
		status.setRollno(rs.getString("roll_no"));
		status.setAttendance(rs.getString("attendance"));
		
		
		list.add(status);
	}
	/* System.out.println("AfterJDBC "+rs.getString("status"));
	 System.out.println("After JDBC"+rs.getString("RoomNo"));*/
	}

	finally{
	// Step -5 Close the resources
	if(rs!=null){	
	rs.close();
	}
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return list;
	
}

public static List<TimeTableDTO> timetable(String sem,String sec) throws ClassNotFoundException, SQLException{
	List<TimeTableDTO> list=new ArrayList<TimeTableDTO>();
	boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	TimeTableDTO status;
	ResultSet rs = null;
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1"); 
	
	 pstmt = con.prepareStatement("select subject , fac_id , time from sec_info where semester='"+sem+"' and section='"+sec+"' ORDER BY  time ASC ");
	 rs = pstmt.executeQuery();
	 while(rs.next()){
		status = new TimeTableDTO();
		status.setSubject(rs.getString("subject"));
		status.setFac_id(rs.getString("fac_id"));
		status.setTime(rs.getString("time"));
		
		
		list.add(status);
	}
	/* System.out.println("AfterJDBC "+rs.getString("status"));
	 System.out.println("After JDBC"+rs.getString("RoomNo"));*/
	}

	finally{
	// Step -5 Close the resources
	if(rs!=null){	
	rs.close();
	}
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return list;
	
}

public static List<FacultyInsecDTO> facinsec(String sem,String sec) throws ClassNotFoundException, SQLException{
	List<FacultyInsecDTO> list=new ArrayList<FacultyInsecDTO>();
	boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	FacultyInsecDTO status;
	ResultSet rs = null;
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1"); 
	 pstmt = con.prepareStatement("select   fac_id , subject from sec_wise_faculty where semester='"+sem+"' and section='"+sec+"'  ");
	 rs = pstmt.executeQuery();
	 while(rs.next()){
		status = new FacultyInsecDTO();
		status.setFac_id(rs.getString("fac_id"));
		status.setSubject(rs.getString("subject"));
		
		
		
		
		list.add(status);
	}
	
	/* System.out.println("AfterJDBC "+rs.getString("status"));
	 System.out.println("After JDBC"+rs.getString("RoomNo"));*/
	}

	finally{
	// Step -5 Close the resources
	if(rs!=null){	
	rs.close();
	}
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return list;
	
}

public static List<FacatttodadayDTO> facatttoday() throws ClassNotFoundException, SQLException{
	List<FacatttodadayDTO> list=new ArrayList<FacatttodadayDTO>();
	boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	FacatttodadayDTO status;
	ResultSet rs = null;
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1"); 
	
	 pstmt = con.prepareStatement("select   * from fac_att" );
	 rs = pstmt.executeQuery();
	 while(rs.next()){
		status = new FacatttodadayDTO();
		status.setFac_id(rs.getString("fac_id"));
		status.setAttendance(rs.getString("attendance"));
		status.setStatus(rs.getString("status"));
		
		
		
		list.add(status);
	}
	/* System.out.println("AfterJDBC "+rs.getString("status"));
	 System.out.println("After JDBC"+rs.getString("RoomNo"));*/
	}

	finally{
	// Step -5 Close the resources
	if(rs!=null){	
	rs.close();
	}
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return list;
	
}
public static List<StudentDetailDTO> studentdetail(String roll_no) throws ClassNotFoundException, SQLException{
	List<StudentDetailDTO> list=new ArrayList<StudentDetailDTO>();
	boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	StudentDetailDTO status;
	ResultSet rs = null;
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1"); 
	
	 pstmt = con.prepareStatement("select roll_no,name,semester,section,subject,sub_att from student_list INNER JOIN student_att on roll_no='"+roll_no+"' AND roll_no=roll" );
	 rs = pstmt.executeQuery();
	 while(rs.next()){
		status = new StudentDetailDTO();
		status.setRoll_no(rs.getString("roll_no"));
		status.setSemester(rs.getString("name"));
		status.setSection(rs.getString("section"));
		status.setSubject(rs.getString("subject"));
		status.setSub_att(rs.getString("sub_att"));
		
		
		
		list.add(status);
	}
	/* System.out.println("AfterJDBC "+rs.getString("status"));
	 System.out.println("After JDBC"+rs.getString("RoomNo"));*/
	}

	finally{
	// Step -5 Close the resources
	if(rs!=null){	
	rs.close();
	}
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return list;
	
}
public static boolean sendlessthanmsg(String roll_no,String criteria) throws ClassNotFoundException, SQLException{
	//List<StudentDetailDTO> list=new ArrayList<StudentDetailDTO>();
	boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	//StudentDetailDTO status;
	int rs;
	String HOD="HOD  *IMP*";
	String message = "Warning!! Your Attendance is less than " +criteria+ "% .Please Attend Classes On Regular Basis.";
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1"); 
	
	 pstmt = con.prepareStatement("Insert INto student_msg (roll_no,msg_from,message) Values('"+roll_no+"','"+HOD+"','"+message+"')" );
	 rs = pstmt.executeUpdate();
	if(rs==1){
		result = true;
		
		}
	/* System.out.println("AfterJDBC "+rs.getString("status"));
	 System.out.println("After JDBC"+rs.getString("RoomNo"));*/
	}

	finally{
	// Step -5 Close the resources
	
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return result;
	
}
public static List<MessageDTO> message() throws ClassNotFoundException, SQLException{
	List<MessageDTO> list=new ArrayList<MessageDTO>();
	boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	MessageDTO status;
	ResultSet rs = null;
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1"); 
	
	 pstmt = con.prepareStatement("select * from HOD_msgs");
	 rs = pstmt.executeQuery();
	 while(rs.next()){
		 status = new MessageDTO();
			status.setFrom(rs.getString("from"));
			status.setAbout(rs.getString("about"));
			status.setMsg_content(rs.getString("msg_content"));
			status.setTime(rs.getString("time"));
		
		
		list.add(status);
	}
	/* System.out.println("AfterJDBC "+rs.getString("status"));
	 System.out.println("After JDBC"+rs.getString("RoomNo"));*/
	}

	finally{
	// Step -5 Close the resources
	if(rs!=null){	
	rs.close();
	}
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return list;
	
}

public static List<SemMain> classStatus() throws ClassNotFoundException, SQLException{
	List<SemMain> list=new ArrayList<SemMain>();
	boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	SemMain status;
	ResultSet rs = null;
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1");
	
	 pstmt = con.prepareStatement("select * from sec_status");
	 rs = pstmt.executeQuery();
	 int i =0;
	 while(rs.next()){
		status = new SemMain();
		status.setSem(rs.getString("semester"));
		status.setSec(rs.getString("section"));
		status.setStatus(rs.getString("status"));
		status.setRoomno(rs.getString("RoomNo"));
		
		list.add(i, status);
		i++;
	}
	/* System.out.println("AfterJDBC "+rs.getString("status"));
	 System.out.println("After JDBC"+rs.getString("RoomNo"));*/
	}

	finally{
	// Step -5 Close the resources
	if(rs!=null){	
	rs.close();
	}
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return list;
	
}
public static List<FacatttodadayDTO> facatttodaybyid(String facid) throws ClassNotFoundException, SQLException{
	List<FacatttodadayDTO> list=new ArrayList<FacatttodadayDTO>();
	boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	FacatttodadayDTO status;
	ResultSet rs = null;
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1"); 
	
	 pstmt = con.prepareStatement("select   * from fac_att where fac_id='"+facid+"'" );
	 rs = pstmt.executeQuery();
	 while(rs.next()){
		status = new FacatttodadayDTO();
		status.setFac_id(rs.getString("fac_id"));
		status.setAttendance(rs.getString("attendance"));
		status.setStatus(rs.getString("status"));
		
		
		
		list.add(status);
	}
	/* System.out.println("AfterJDBC "+rs.getString("status"));
	 System.out.println("After JDBC"+rs.getString("RoomNo"));*/
	}

	finally{
	// Step -5 Close the resources
	if(rs!=null){	
	rs.close();
	}
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return list;
	
}
public static boolean engage(String sem , String sec , String fac_id) throws ClassNotFoundException, SQLException{
	List<FacatttodadayDTO> list=new ArrayList<FacatttodadayDTO>();
	boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	int rs,rsv ;
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1"); 
	String status2 = "Taken";
	String status3 = "Busy";
	 pstmt = con.prepareStatement("UPDATE  sec_status set status='"+status2+"' where semester='"+sem+"' AND section='"+sec+"' ");
	 pstmt2 = con.prepareStatement("UPDATE  fac_att set status='"+status3+"' where  fac_id='"+fac_id+"' ");
	 rs = pstmt.executeUpdate();
	 rsv = pstmt2.executeUpdate();
	 
	if(rs==1 && rsv==1)
	 {
		 result=true;
	 }
		
		
	}

	finally{
	// Step -5 Close the resources
	
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return result;
	
}
public static boolean sendtofac(String msgto ,String msgfrom ,  String msgabout , String msg_content) throws ClassNotFoundException, SQLException{
	boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	int rs;
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1"); 
	 pstmt = con.prepareStatement("insert into fac_msgs(msg_to,msg_from,msg_about,msg_content) values('"+msgto+"','"+msgfrom+"','"+msgabout+"','"+msg_content+"')");
	 rs = pstmt.executeUpdate();
	 
	if(rs==1)
	 {
		 result=true;
	 }
		
		
	}

	finally{
	// Step -5 Close the resources
	
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return result;
	
}
public static boolean sendtostudent(String msgto ,String msgfrom ,  String msgabout , String msg_content) throws ClassNotFoundException, SQLException{
	boolean result = false;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	int rs;
	try{
	con = getConnection();
	//Step -3 Query 
	 stmt = con.createStatement();
	// Step -4 Result 
	// select userid,password from user where userid='amit' and password='123'
//System.out.println("1"); 
	 pstmt = con.prepareStatement("insert into student_msg(roll_no,msg_from,message) values('"+msgto+"','"+msgfrom+"','"+msg_content+"')");
	 rs = pstmt.executeUpdate();
	 
	if(rs==1)
	 {
		 result=true;
	 }
		
		
	}

	finally{
	// Step -5 Close the resources
	
	if(stmt!=null){
	stmt.close();
	}
	if(con!=null){
	con.close();
	}
	}
	return result;
	
}

}
