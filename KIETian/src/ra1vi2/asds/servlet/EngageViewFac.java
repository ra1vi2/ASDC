package ra1vi2.asds.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.asds.jdbc.JDBC;


@WebServlet("/engagefac")
public class EngageViewFac extends HttpServlet {
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
			try
			{
		     String sem = request.getParameter("sem");
			String sec = request.getParameter("sec");
			String fac_id = request.getParameter("fac_id");
			
			boolean result = JDBC.engage(sem, sec, fac_id);
			
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("classstatus");
			rd.forward(request, response);
			
			}
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
