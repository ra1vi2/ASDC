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


@WebServlet("/lessthanservlet")
public class LessThan extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			doPost(request, response);

		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
       HttpSession session = request.getSession(false);
     String criteria =request.getParameter("criteria");
     System.out.println("criteria"+criteria);
		//String criteria ="70";
		if(session==null || session.getAttribute("facid")==null)
		{
			//
			response.sendRedirect("login.jsp");
		}

		else
		{
			try
			{
				session.setAttribute("criteria", criteria);
			String semnsec =(String)session.getAttribute("semnsec");
			
			String sem = semnsec.substring(0, 1);
			String sec = semnsec.substring(2,3);

			System.out.println(sem);
			System.out.println(sec);
			System.out.println(criteria);
			List<StudentListDTO> list = JDBC.studentlessthan(sem,sec,criteria);
               request.setAttribute("list",list);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("lessthan.jsp");
			rd.forward(request, response);
	

	}
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

}
	}

}
