package ra1vi2.asds.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ra1vi2.asds.DTO.StudentListDTO;

import com.asds.jdbc.JDBC;

@WebServlet("/composemsg")
public class ComposeMessage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
HttpSession session = request.getSession(false);
		
		if(session==null || session.getAttribute("facid")==null)
		{
			//
			response.sendRedirect("login.jsp");
		}
		
		else
		{
			try{
				String facid = (String)session.getAttribute("facid");
				String msgto = request.getParameter("msgto");
				String msgabout = request.getParameter("msgabout");
				String msg_content = request.getParameter("msg_content"); 
				boolean result = false;
		
				System.out.println("Msg to " + msgto);
				System.out.println("msg about " + msgabout);
				System.out.println("msg " + msg_content);
				msgto.trim();
			String []recipients = msgto.split(";");
			
			for(String rec : recipients)
			{
				char []charrec = rec.toCharArray();
				
				if(charrec[0]=='f')
				{
					//send to fac
					result = JDBC.sendtofac(rec, facid, msgabout, msg_content);
				}
				else if(charrec[0]=='s' && charrec.length==4 && charrec[2]=='m')
				{
					//get sem
					//send to whole sem
					String sem = Character.toString(charrec[3]);
					List<StudentListDTO> list = JDBC.studentlistsem(sem);
					
					for(StudentListDTO student : list)
					{
					String roll_no = student.getRollno();
					result = JDBC.sendtostudent(roll_no,facid, msgabout, msg_content);
					}	
					
				}
				else if(charrec[0]=='s' && charrec.length==8)
				{
					//get sem
					//get sec
					//send to sec
					String sem = Character.toString(charrec[3]);
					String sec = Character.toString(charrec[7]);
			
					List<StudentListDTO> list = JDBC.studentlist(sem,sec);
					for(StudentListDTO student : list)
					{
					String roll_no = student.getRollno();
					result = JDBC.sendtostudent(roll_no,facid, msgabout, msg_content);
					}
					
				}
				else if(charrec[0]=='1')
			    {
					//send to student
					result = JDBC.sendtostudent(rec, facid, msgabout, msg_content);
				 }
				else
				{
					//send error
					System.out.println("No rec Found");
					result=false;
				}
			}
			

			request.setAttribute("result",result);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("composemsg.jsp");
			rd.forward(request, response);
			}
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
