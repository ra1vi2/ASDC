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



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String facid=request.getParameter("facid");
		String password=request.getParameter("password");
		
		try {
			if(JDBC.checksLogin(facid, password)){
				HttpSession session = request.getSession(true);
				session.setAttribute("facid",facid );
		
				response.sendRedirect("viewhome.jsp");
			}
			else{ request.setAttribute("result","fail");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);}
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
