package ra1vi2.asds.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ra1vi2.asds.DTO.FacatttodadayDTO;
import ra1vi2.asds.DTO.FacultyInsecDTO;
import ra1vi2.asds.DTO.FreeFacNSec;
import ra1vi2.asds.DTO.SemMain;

import com.asds.jdbc.JDBC;


@WebServlet("/classstatus")
public class ClassStatus extends HttpServlet {
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
				String result=null;
				try{
				List<SemMain> list = JDBC.classStatus();
				
				int iter = 0;
				List<FreeFacNSec> freefacnsec = new ArrayList<FreeFacNSec>();
				FreeFacNSec list2;
				for(SemMain i : list)
				{
					int fresemit = 0;
					String status = i.getStatus();
			
					if(status.equalsIgnoreCase("free"))
					{
						String sem = i.getSem();
						String sec = i.getSec();
						
						List<FacultyInsecDTO> facinsec = JDBC.facinsec(sem,sec);
						
						
						for(FacultyInsecDTO fac : facinsec)
						{
							//String facid = "No Faculty Free";
						String facid = fac.getFac_id();
							List<FacatttodadayDTO> facatttoday = JDBC.facatttodaybyid(facid);
							int z=0;
						   for(FacatttodadayDTO facdto  : facatttoday)
							 {
								
								String statusoffac = facdto.getStatus();
								
								if(statusoffac.equalsIgnoreCase("free"))
								{
									
									list2 = new FreeFacNSec();
									list2.setSem(sem);
									list2.setSec(sec);
									list2.setFac_id(facid);
									freefacnsec.add(iter, list2);
									iter++;
								}
								
								
							
							}
						}
						
					}
				}
				try{
					boolean res = (Boolean)request.getAttribute("result");
					if(res)
					{
						System.out.println(res + " value of res");
						result = "true";
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				request.setAttribute("freefacnsec", freefacnsec);
				request.setAttribute("result",result);
				RequestDispatcher rd = request.getRequestDispatcher("classstatus.jsp");
				rd.forward(request, response);
				
				}
				catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

}
