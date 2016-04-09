package ra1vi2.asds.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/reply")
public class ReplyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
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
			String to = request.getParameter("from");
			String about = request.getParameter("about");
			String from = (String)session.getAttribute("facid");
			
			request.setAttribute("to", to);
			request.setAttribute("about", about);
			request.setAttribute("from", from);
			
			RequestDispatcher rd = request.getRequestDispatcher("reply.jsp");
			rd.forward(request, response);
			
		}
	}

}
