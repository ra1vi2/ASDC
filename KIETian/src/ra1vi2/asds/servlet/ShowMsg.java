package ra1vi2.asds.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/showmsg")
public class ShowMsg extends HttpServlet {
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
				  String msg_content = request.getParameter("content");
	    		        String from = request.getParameter("from");
				  String about = request.getParameter("about");
				  String time = request.getParameter("time");
				 
		
		
				  if (msg_content != null) { 
					  request.setAttribute("msg_content",msg_content);
					  request.setAttribute("from",from);
					  request.setAttribute("about", about);
					  request.setAttribute("time", time);
					
						RequestDispatcher rd = request.getRequestDispatcher("showmsg.jsp");
						rd.forward(request, response);
			        }
				  else
				  {
					  System.out.println("Null Msg_contetn Here");
				  }
			}
	}

}
