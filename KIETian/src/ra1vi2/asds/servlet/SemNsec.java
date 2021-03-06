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

import com.asds.jdbc.JDBC;

import ra1vi2.asds.DTO.SemMain;


@WebServlet("/semnsec")
public class SemNsec extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		
		if(session==null|| session.getAttribute("facid")==null)
		{
			//
			response.sendRedirect("login.jsp");
		}

		else
		{
			try
			{
			String semnsec = request.getParameter("value");
			//String semnsec = "8-B";
			session.setAttribute("semnsec",semnsec );
			String sem = semnsec.substring(0, 1);
			String sec = semnsec.substring(2,3);
			
/*			System.out.println("sem" + sem);
			System.out.println("sec"+sec);
*/			
			List<SemMain> status = JDBC.secStatus(sem,sec);
			request.setAttribute("status",status);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("sem2secA.jsp");
			rd.forward(request, response);
	
	}
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
}
