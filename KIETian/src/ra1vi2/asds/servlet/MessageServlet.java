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

import ra1vi2.asds.DTO.FacatttodadayDTO;
import ra1vi2.asds.DTO.MessageDTO;

import com.asds.jdbc.JDBC;


@WebServlet("/messages")
public class MessageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				try
				{
					List<MessageDTO> list = JDBC.message();
					
					request.setAttribute("list", list);
					
					RequestDispatcher rd = request.getRequestDispatcher("viewmessage.jsp");
					
					rd.forward(request, response);
				}
				catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
	}

}
